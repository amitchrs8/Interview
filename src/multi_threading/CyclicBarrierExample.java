package multi_threading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierExample {

    private static void testCyclicBarrier() throws InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(3,()->{
            System.out.println("All Parties have arrived , lets start the execution !!!");
        });

        Runnable task = ()->{
            System.out.println("Thread "+Thread.currentThread().getName()+"  calling await");
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Waiting parties : "+ barrier.getNumberWaiting());
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        };

        Thread t1 = new Thread(task , "T1");
        Thread t2 = new Thread(task , "T2");
        Thread t3 = new Thread(task , "T3");

        t1.start();
        t2.start();
        t3.start();

    }



    public static void main(String[] args) throws InterruptedException {
        testCyclicBarrier();
    }

}
