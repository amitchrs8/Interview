package multi_threading;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTaskExec {

    private static void testTimer01() {

        Timer timer = new Timer();

        TimerTask badTask = new TimerTask() {
            @Override
            public void run() {
                while (Boolean.TRUE) {
                    System.out.println("Bad Task Running");
                }
            }
        };

        TimerTask goodTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Good Task running!!!");
            }
        };
        timer.schedule(badTask, 100);
        timer.schedule(goodTask, 500);
    }

    private static void testTimer_02() throws InterruptedException {
        Timer timer = new Timer();
        TimerTask badTask = new TimerTask() {
            @Override
            public void run() {
                throw new RuntimeException("Something bad happened !!!");
            }
        };

        TimerTask goodTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Good Task Running !!!");
            }
        };
        timer.schedule(badTask, 10);
        Thread.sleep(500);
        timer.schedule(goodTask, 10);

    }


    public static void main(String[] args) throws InterruptedException {

//        testTimer01();
        testTimer_02();
    }

}
