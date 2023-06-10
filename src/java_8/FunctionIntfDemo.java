package java_8;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class FunctionIntfDemo {



    private static void testFunction(){

        Function<String,String> testF1 = (str) -> str.toUpperCase();
        System.out.println("Using testF1 : "+testF1.apply("amit"));
        //Compose function
        Function<Integer, Integer> increment = x->x+20;
        Function<Integer,Integer> multiply = y->y*5;
        System.out.println("Compose Function Testing 1 : "+increment.compose(multiply).apply(3));
        System.out.println("Compose Function Testing 2 : "+increment.andThen(multiply).apply(3));

        BiFunction<Integer,Integer,Integer> add = (a,b)->a+b;
        System.out.println("Bifunction Testing : "+add.apply(3,8));

        UnaryOperator<Integer> square = a -> a*a;
        System.out.println("UnaryOpe Square : "+square.apply(23));

        BinaryOperator<Integer> multiplyBin = (a,b) -> a*b;
        System.out.println("BinaryOp Multiply : "+multiplyBin.apply(4,9));

    }


    public static void main(String[] args) {
    testFunction();
    }

}
