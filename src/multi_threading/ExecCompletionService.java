package multi_threading;

import javax.security.auth.callback.Callback;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ExecCompletionService {

    private static void testCompletionService(int temp){

        Runnable task = ()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Executor Thread : "+Thread.currentThread().getName());
            System.out.println(temp*temp*temp);
        };

        ExecutorCompletionService<Integer> exec = new ExecutorCompletionService<>(Executors.newFixedThreadPool(2));
        IntStream.range(0,10).forEach(i->
                {
                    exec.submit(task,i);
                }
        );




    }


    public static void main(String[] args) {

    }
}
