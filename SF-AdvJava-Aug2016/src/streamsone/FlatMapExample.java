package streamsone;

import java.util.Arrays;
import java.util.stream.Stream;

public class FlatMapExample {
    public static void main(String[] args) {
        Stream.of("Fred", "", "Jim", "Sheila")
                .flatMap(s->{
                    if (s.equals("Jim")) return Stream.empty();
                    char[] ca = s.toCharArray();
                    String[] sa = new String[ca.length];
                    for (int i = 0; i < ca.length; i++) {
                        sa[i] = "" + ca[i];
                    }
                    return Stream.of(sa);
                })
                .forEach(System.out::println);
                ;
    }
}
