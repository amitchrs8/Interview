package java_8;

import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class SupplierDemo {

    private static void testSupplier(){
        Supplier<Integer> randomSupplier = () -> 33 * 20;

        Supplier<Person> personSupplier = () -> new Person("Amit",32);

        IntSupplier intSup = () -> (int)Math.random() * 10000;

        DoubleSupplier dubSup = () -> Math.random();

        System.out.println("Random Supplier : "+randomSupplier.get());
        System.out.println("Person Supplier : "+personSupplier.get());
        System.out.println("Int Supplier : "+intSup.getAsInt());
        System.out.println("Double Supplier : "+dubSup.getAsDouble());



    }
    public static void main(String[] args) {
        testSupplier();
    }
}
