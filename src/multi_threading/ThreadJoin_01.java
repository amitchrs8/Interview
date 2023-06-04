package multi_threading;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ThreadJoin_01 {

    private static void threadJoinTest(){
        Runnable task = ()-> {
            System.out.println("Thread start : "+ new Date() + " , "+Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread start : "+ new Date() + " , "+Thread.currentThread().getName());
        };
        Thread t = new Thread(task);
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    /*
    This method shows how to serially execute different threads. next Thread will start only after first Thread has completed Execution.
     */
    private static void threadJoinMultiTest(){

        Runnable task = ()->{
            System.out.println(" Started Thread : "+Thread.currentThread().getName() + " , Time : "+new Date());
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(" Finished Thread : "+Thread.currentThread().getName() + " , Time : "+new Date());

        };

        Thread t1 = new Thread(task,"T1");
        Thread t2 = new Thread(task,"T2");
        Thread t3 = new Thread(task,"T3");

        t1.setDaemon(Boolean.TRUE);
        t2.setDaemon(Boolean.TRUE);
        t3.setDaemon(Boolean.TRUE);

        t1.start();
        try {
            t1.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        t3.start();
        try {
            t3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }




    public static void main(String[] args) {
        System.out.println("Before Calling threadJoinTest");
//        threadJoinTest();
        threadJoinMultiTest();
        System.out.println("After Calling threadJoinTest");
    }








}


