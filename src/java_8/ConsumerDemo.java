package java_8;


import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerDemo {

    private static void testConsumer(){

        Consumer<String> stringConsumer = (s) -> System.out.println(s.toUpperCase());
        stringConsumer.accept("Amit");

        Consumer<Integer> intConsumer = (num) -> System.out.println(num*num*num);
        intConsumer.accept(12);

        Consumer<String> cons1 = (s)-> System.out.println("My Name is "+s);
        Consumer<String> cons2 = (p)-> System.out.println("I am from India. "+p);

        cons1.andThen(cons2).accept("Amit");
    }


    private static void testBiConsumer(){

        BiConsumer<String, String> bic = (s1,s2)-> System.out.println("First : "+s1 + " , Second : "+s2);
        bic.accept("Amit","Chaurasia");
    }

    public static void main(String[] args) {
        testConsumer();
        testBiConsumer();
    }

}
