package Basics.collections;

import java.security.SecureRandom;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class CopyOnWriteArrayListDemo {

    private static void testMultiThreadedAddition() throws InterruptedException {
        List<Integer> cwList = new CopyOnWriteArrayList<>();
        SecureRandom rand = new SecureRandom();
        CountDownLatch cd = new CountDownLatch(20);
        Runnable task = () -> {
            int num = rand.nextInt(1000);
            System.out.println("Adding : "+num + " , Thread : "+Thread.currentThread().getName());
            cwList.add(num);
            cd.countDown();
        };
        ExecutorService pool = Executors.newFixedThreadPool(5);
        IntStream.range(0,20).forEach(e->{
            pool.submit(task);
        });

        pool.shutdown();
        cd.await();
        System.out.println("Final List : "+cwList);
        System.out.println("Final List size : "+cwList.size());
    }


    public static void main(String[] args) throws InterruptedException {
        testMultiThreadedAddition();
    }

}
