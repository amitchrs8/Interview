package multi_threading;

import java.util.concurrent.*;

public class CallableExample {

    private static void testCall(int temp) throws ExecutionException, InterruptedException, TimeoutException {
        Callable<Integer> callTask = () -> {
            return temp * temp * temp;
        };

        ExecutorService exec = Executors.newFixedThreadPool(2);
        Future<Integer> fut = exec.submit(callTask);
        System.out.println("Result of Execution : " + fut.get(5, TimeUnit.SECONDS));
        exec.shutdown();
    }

    private static void testFut(int temp){
    Callable<Integer> task = ()->{
      TimeUnit.SECONDS.sleep(5);
        System.out.println("call task getting executed by Thread : "+Thread.currentThread().getName());
      return temp*temp;
    };

    ExecutorService exec = Executors.newFixedThreadPool(2);
    Future<Integer> fut = exec.submit(task);
    try {
        System.out.println("Future result : " + fut.get(2, TimeUnit.SECONDS));
    }catch (Exception e){
        System.err.println("Exception while getting future result : "+e.getMessage());
    }
    exec.shutdown();
    }

    private static void testFutureTask(int temp) throws ExecutionException, InterruptedException {

        FutureTask<Integer> futTask = new FutureTask<>(()->{
            return temp*temp;
        });

        ExecutorService exec = Executors.newFixedThreadPool(3);
        Future fut = exec.submit(futTask);
        System.out.println("Got the Future value : "+fut.get());
        System.out.println("Got the FutureTask value : "+futTask.get());
        exec.shutdown();
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
//        testCall(9);
//        testFut(12);
        testFutureTask(32);
    }
}
