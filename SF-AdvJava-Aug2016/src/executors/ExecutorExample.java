package executors;

import java.time.LocalDateTime;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

class MyJob implements Callable<String> {
    // Unnecessary All constrution work is done in main thread
    private static final AtomicInteger nextId = new AtomicInteger(); 
    private final int myId = nextId.incrementAndGet();
    
    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() 
                + " Job " + myId + " starting...");
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 3000));
        } catch (InterruptedException ie) {
            System.out.println("Interrupted!!!");
        }
        return "Job " + myId + " completed at " + LocalDateTime.now();
    }
}

public class ExecutorExample {
    public static void main(String[] args) {
        final int JOB_COUNT = 6;
        ExecutorService es = Executors.newFixedThreadPool(2);
        @SuppressWarnings("unchecked")
        Future<String>[] jobs = new Future[JOB_COUNT];
        
        for (int i = 0; i < JOB_COUNT; i++) {
            jobs[i] = es.submit(new MyJob());
        }

        for (int i = 0; i < JOB_COUNT; i++) {
//            if (jobs[i].isDone()) {
                try {
                    System.out.println("Job " + i + " completed with: " + jobs[i].get());
                } catch(ExecutionException ee) {
                    System.out.println("Job " + i + " ended with " + ee.getCause().getMessage());
                } catch(InterruptedException ie) {
                    System.out.println("Shouldn't happen, someone interrupted our call to get()!");
                }
//            }
        }
        
        System.out.println("All jobs completed, shutting down");
//        es.shutdown();
    }
}
