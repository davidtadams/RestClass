package functionalfilter;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FilterExperiments {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Fred", "Jim",
                "Sheila", "Susan", "van der Linden", "Orinoco");
        System.out.println("Strings longer than 4: "
                + Filter.filter(strings, s -> s.length() > 4));
        System.out.println("Strings with initial caps: "
                + Filter.filter(strings, s -> Character.isUpperCase(s.charAt(0))));
        
        Set<LocalDate> times = new HashSet<>();
        times.addAll(Arrays.asList(
                LocalDate.of(2016, Month.AUGUST, 6),
                LocalDate.of(1999, Month.DECEMBER, 31),
                LocalDate.of(2030, Month.MARCH, 1),
                LocalDate.of(1970, Month.JANUARY, 1)
        ));
        
        System.out.println("Firsts of month: " 
                + Filter.filter(times, d->d.getDayOfMonth()==1));
        System.out.println("Future dates: "
                + Filter.filter(times, d->d.compareTo(LocalDate.now()) > 0));
        System.out.println("Fridays: "
                + Filter.filter(times, d->d.getDayOfWeek()==DayOfWeek.FRIDAY));
    }
}
