package streamsone;

import java.util.stream.IntStream;

public class InfiniteStream {
    public static void main(String[] args) {
//        boolean result = 
        IntStream.iterate(0, n->n+2)
//                .forEach(n->System.out.println(n));
                .peek(s->System.out.println("peek: " + s))
                .skip(20)
                .limit(10)
                .allMatch(n-> n % 3 == 0)
                ;
//                .forEach(System.out::println);
//        System.out.println("result " + result^);
    }
}
