package Basics.collections;

import java.util.*;

public class HashMapDemo {


    private static void  educativePuzzle01(){
        Map<String, Integer> stockPrice = new HashMap<>();
        stockPrice.put("Oracle", 56);
        stockPrice.put("Fiserv", 117);
        stockPrice.put("BMW", 73);
        stockPrice.put("Microsoft", 213);
        stockPrice.put("Google", 421);
        stockPrice.put("Ford", 456);
        stockPrice.put("Novartis", 43);
        stockPrice.put("TCS", 23);

        String[] companyHighestStockPrice = {null};
        int [] highestStockVal={0};
        stockPrice.entrySet().stream().forEach(e->{
            if(e.getValue() > highestStockVal[0]){
                highestStockVal[0] = e.getValue();
                companyHighestStockPrice[0] = e.getKey();
            }
        });

        System.out.println("Company : "+companyHighestStockPrice[0]+ " , StockPrice : "+highestStockVal[0]);

        System.out.println("Average Stock Price : "+stockPrice.values().stream().mapToInt(i->i).average());
        List<String> list = new ArrayList<>();
        Iterator<Map.Entry<String, Integer>> entryIterator = stockPrice.entrySet().stream().iterator();

          while(entryIterator.hasNext()){
              Map.Entry val = entryIterator.next();
              if((int)val.getValue() < 50){
                  list.add(val.getKey().toString());
              }
          }

        System.out.println("Keys to be rremved : "+list);
          list.stream().forEach(k->stockPrice.remove(k));
        System.out.println("StockPrice after removing less thatn 50 value stock : "+stockPrice);

    }



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
//        computeOpsOnHashMap();
        educativePuzzle01();

    }

}
