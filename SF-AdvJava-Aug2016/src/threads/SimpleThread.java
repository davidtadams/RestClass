package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleThread {
    public static void main(String[] args) {
        Runnable r = new Runnable() {
            private int i = 0;
            @Override
            public void run() {
                for (; i < 10_000; i++) {
                    System.out.println(Thread.currentThread().getName() + ":  " + i);
                }
            }
        };
        
//        Thread t1 = new Thread(r);
//        Thread t2 = new Thread(r);
//        t1.start();
//        t2.start();

        ExecutorService es = Executors.newFixedThreadPool(4);
        es.execute(r);
        es.execute(r);
        System.out.println("Main finishing");
    }
}
