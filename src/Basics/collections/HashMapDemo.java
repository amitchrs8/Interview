package Basics.collections;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {



    private static void computeOpsOnHashMap(){
        Map<String, Integer> map = new HashMap<>();
        map.put("India", 5);
        map.put("USA", 3);
        map.put("China", 5);
        map.put("Russia", 6);
        System.out.println("USA value before : "+map.get("USA"));
        map.compute("USA",(k,v)-> v==null?10:v+5);
        System.out.println("USA value after : "+map.get("USA"));
        map.computeIfAbsent("GHANA",k->120);
        System.out.println("Ghana Value "+map.get("GHANA"));

        map.computeIfPresent("USA",(k,v)-> v==null?321:45);
        System.out.println("USA recomputed value : "+map.get("USA"));
    }

    public static void main(String[] args) {
        computeOpsOnHashMap();


    }

}
