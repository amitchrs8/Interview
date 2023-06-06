package multi_threading;

import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class CountDownLatchExample {


    private static void testCountDownLatch() throws InterruptedException {
        CountDownLatch cd  = new CountDownLatch(10);

        Runnable workerTask = ()->{
            System.out.println("Worker Task --- Thread "+Thread.currentThread().getName()+ " started execution!!! Counter - "+cd.getCount() + " , at : "+ new Date());
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            cd.countDown();
            System.out.println("Thread "+Thread.currentThread().getName()+ " Finishing execution!!! Counter - "+cd.getCount() + " , at : "+ new Date());
        };

        ExecutorService pool = Executors.newFixedThreadPool(4);
        IntStream.range(0,10).forEach(i->{
            pool.submit(workerTask);
        });

        cd.await();
        System.out.println("Walked past  await at : "+new Date());
        Runnable masterTask = ()->{
            System.out.println("MAster Task --- getting executed now : "+new Date()+ " , by Thread : "+Thread.currentThread().getName());
            System.out.println("Counter value : "+cd.getCount());
        };
        pool.submit(masterTask);
        pool.shutdown();
    }


    public static void main(String[] args)throws InterruptedException {
        testCountDownLatch();
    }
}
