package compoundcomparator;


import java.util.Comparator;

public class CompoundComparator {
    public static <E> Comparator<E> oneThenAnother(Comparator<E> first, Comparator<E> second) {
        return (o1, o2) -> {
            int result = first.compare(o1, o2);
            if (result == 0) {
                result = second.compare(o1, o2);
            }
            return result;
        };
    }
}
