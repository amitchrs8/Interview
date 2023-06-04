package multi_threading;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Threading_001 {




    public static void main(String[] args) {

        startThread01();


    }

    private static void startThread01() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread executing : "+Thread.currentThread().getName() + " , Time : "+ new Date());
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Thread executing : "+Thread.currentThread().getName() + " , Time : "+ new Date());
            }

        });

        t1.start();
    }


}
