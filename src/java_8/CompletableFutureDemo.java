package java_8;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Date;
import java.util.concurrent.*;

public class CompletableFutureDemo {

    private static CompletableFuture<Integer> testCompFuture1(int num){
        CompletableFuture<Integer> completableFuture = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(()->{
            Thread.sleep(5000);
            completableFuture.complete(num*num);
            return null;
        });
        return completableFuture;
    }

    private static void testCompFuture2() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException ie) {
                System.err.println(ie.getMessage());
            }
            System.out.println("Processing : " + Thread.currentThread().getName() + ",, Time : "+new Date());
        });
        System.out.println("This will print immediately"+ ",, Time : "+new Date());
        future.get();
        System.out.println("This will print after 5 sec!!!"+ ",, Time : "+new Date());
    }

    private static void testApply() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("First -- "+Thread.currentThread().getName());
            return (int)(Math.random()*1000);
        });

        CompletableFuture<Integer> resultFuture = future.thenApply(num->{
            System.out.println("Result Future : "+Thread.currentThread().getName());
            return num*num;
        });
        System.out.println("Final Result : "+resultFuture.get());
    }
    private static void testApplyAsync() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("First -- "+Thread.currentThread().getName());
            return (int)(Math.random()*1000);
        });

        CompletableFuture<Integer> resultFuture = future.thenApplyAsync(num->{
            System.out.println("Result Future : "+Thread.currentThread().getName());
            return num*num;
        });
        System.out.println("Final Result : "+resultFuture.get());
    }


    private static void testSupplyAsync() throws ExecutionException, InterruptedException {

        ExecutorService pool = Executors.newFixedThreadPool(2);
        CompletableFuture<String> future = CompletableFuture.supplyAsync(()->
        {
           try{
               TimeUnit.SECONDS.sleep(5);
           }catch (InterruptedException e){
               System.err.println(e.getMessage());
           }
            System.out.println("From teh Comp Future Task : "+Thread.currentThread().getName()+ ", Time : "+new Date());
            return "Hello World";
        },pool);

        System.out.println("Will eb printed Immediately : "+Thread.currentThread().getName()+ ", Time : "+new Date());

        System.out.println("Result of call : "+future.get());

        System.out.println("Will be printed after sleep pause : "+Thread.currentThread().getName()+ " , Time : "+new Date());
        pool.shutdown();
    }

    private static void testThenAccept(){
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(()->{
            System.out.println("First Future : "+Thread.currentThread().getName());
            return 12;
//            try {
//                return SecureRandom.getInstanceStrong().nextInt();
//            } catch (NoSuchAlgorithmException e) {
//                throw new RuntimeException(e);
//            }
        });

        future.thenAccept(num->{
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Accept Future : "+Thread.currentThread().getName());

            System.out.println("Number received is : "+num);
        });

    }


    private static void testThenCompose() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(()->{
            return 12;
        });

        CompletableFuture<Integer> future2 = future1.thenCompose((num)->CompletableFuture.supplyAsync(()->num*2));
        CompletableFuture<Integer> future3 = future2.thenCompose((num)->CompletableFuture.supplyAsync(()->num*num));

        System.out.println("Final Result of Compose : "+future3.get());

    }

    private static void testThenCombine() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer>  future = CompletableFuture.supplyAsync(()->2);
        CompletableFuture<Integer> resultFuture = future.thenCombine(CompletableFuture.supplyAsync(()->3),(n1,n2)->(int)Math.pow(n1,n2));
        System.out.println("Final Combine Result : "+resultFuture.get());
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        System.out.println("Calling get on compFuture");
//        System.out.println(testCompFuture1(4).get());
//        System.out.println("Called get on compFuture");

//        testCompFuture2();
//        testSupplyAsync();
//        testApply();
//        testApplyAsync();
//        testThenAccept();
//        testThenCompose();
        testThenCombine();
    }
}
