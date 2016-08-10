package streamsone;

import java.util.Arrays;
import java.util.List;

public class SimpleStream {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList(
                "Fred", "deJong", "Jim", "van Jones",
                "Algernon"
        );
        
        strings.stream()
                .filter(s->Character.isUpperCase(s.charAt(0)))
                .mapToInt(s->s.length())
                .forEach(l->System.out.println("> " + l));
    }
}
