package completable;

import java.util.concurrent.CompletableFuture;

public class Completable {
    public static void main(String[] args) throws Throwable {
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(()->{
            System.out.println("Starting chain");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie){}
            return "Finished step one";
        });
        
        System.out.println("Main thread still going...");
        f1.thenAccept(System.out::println);
        System.out.println("Still still goin...");
        Thread.sleep(5000);
    }
}
