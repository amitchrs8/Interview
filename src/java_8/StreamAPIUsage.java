package java_8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPIUsage {

    private static void testStream(){
        Stream<Integer> streamInt = Stream.of(2,4,24,7,8,11,21);
        System.out.println(streamInt.filter(a->a%2==0).mapToInt(i->i*i).max().getAsInt());

    }

    private static void testMapper(){
        List<String> list = new ArrayList<>();
        list.add("Dave");
        list.add("Joe");
        list.add("Ryan");
        list.add("Iyan");
        list.add("Ray");

        System.out.println("List of String length : "+list.stream().mapToInt(a->a.length()).boxed().collect(Collectors.toList()));

        System.out.println(list.stream().collect(Collectors.toMap(a->a, a->a.length())));
    }

private static void testFlatMap(){
    List<List<String>> list = new ArrayList<>();
    list.add(Arrays.asList("a","b","c"));
    list.add(Arrays.asList("d","e","f"));
    list.add(Arrays.asList("g","h","i"));
    list.add(Arrays.asList("j","k","l"));

    System.out.println("FlatMap -- "+list.stream().flatMap(a->a.stream()).collect(Collectors.toList()));


}




    public static void main(String[] args) {
//        testStream();
//        testMapper();
        testFlatMap();
    }


}
