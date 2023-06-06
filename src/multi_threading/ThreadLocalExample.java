package multi_threading;


import java.util.stream.IntStream;

class UnSafeCounter {
//    int count = 0;
    ThreadLocal<Integer> count = ThreadLocal.withInitial(()->0);

    void increment() {
//        count++;
        count.set(count.get()+1);
    }
}

public class ThreadLocalExample {

    public static void main(String[] args) {
        UnSafeCounter usc = new UnSafeCounter();
        Thread[] tasks = new Thread[100];

        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(() -> {
                IntStream.range(0, 100).forEach(j -> {
                    usc.increment();
                });
                System.out.println("Thread level value of counter : " + usc.count.get());
            });
            tasks[i] = t;
            t.start();
        }

        IntStream.range(0, 100).forEach(k -> {
            try {
                tasks[k].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println("Final value of counter : " + usc.count.get());

    }

}
