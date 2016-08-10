package functionalfilter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class Filter {
    public static <E> List<E> filter(Collection<E> input, Predicate<E> predicate) {
        List<E> output = new ArrayList<>();
        for (E item : input) {
            if (predicate.test(item)) {
                output.add(item);
            }
        }
        return output;
    }
}
