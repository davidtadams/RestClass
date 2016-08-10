package concordance;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Concordance {
    public static void main(String[] args) throws Throwable {
        Files.lines(Paths.get("PrideAndPrejudice.txt"))
                .flatMap(l->Stream.of(l.split("\\W+")))
                .map(String::toLowerCase)
                .filter(s->s.length() > 0)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((e1,e2)->Long.compare(e2.getValue(), e1.getValue()))
                .limit(200)
                .forEach(e->System.out.printf("%20s : %5d\n", e.getKey(), e.getValue()))
                ;
    }
}
