package compoundcomparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class TestCompoundComparators {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.addAll(Arrays.asList(
                "Aardvark", "aardvark", "Zedd", "Aces", "Fred", "algernon", "Jim", "jim", "axe", "Algernon"
        ));
        
        strings.sort((o1, o2) -> o1.compareTo(o2));
        System.out.println("simple alpha sort " + strings);

        strings.sort((o1, o2) -> o1.length() - o2.length());
        System.out.println("length sort " + strings);
        
        Collections.shuffle(strings);
        System.out.println("Shuffled " + strings);
        
        strings.sort(CompoundComparator.oneThenAnother(
                (o1, o2) -> o1.length() - o2.length(), 
                (o1, o2) -> o1.compareToIgnoreCase(o2)));
        System.out.println("length then alpha " + strings);
        
        Consumer<String> cs = s->System.out.printf("> %14s\n", s);
        Predicate<String> ps = null;
        strings.forEach(/*(Consumer<String>)(*/s->System.out.printf("> %14s\n", s)/*)*/);
        
    }
}
