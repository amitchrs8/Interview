package java_8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateDemo {


    private static void testBiPredicate(){

        BiPredicate<Person, Integer> isOlderThan = (a,b)-> a.age > b;

        Person p = new Person("Amit", 30);

        System.out.println(isOlderThan.test(p,25));

    }


    private static void testPersonAge(){
        Predicate<Person> agePredicate18 = p->p.age >18;
        Predicate<Person> workingAgePErson = p->(p.age > 20 && p.age <=60);

        Person p1 = new Person("Per1", 50);
        Person p2 = new Person("Per2", 23);
        Person p3 = new Person("Per3", 12);
        Person p4 = new Person("Per4", 65);
        Person p5 = new Person("Per5", 15);
        Person p6 = new Person("Per6", 76);

        List<Person> listPersons = new ArrayList<>();
        listPersons.add(p1);
        listPersons.add(p2);
        listPersons.add(p3);
        listPersons.add(p4);
        listPersons.add(p5);
        listPersons.add(p6);

        System.out.println("Adult People List : "+listPersons.stream().filter(agePredicate18).collect(Collectors.toList()));
        System.out.println("Working Age People List : "+listPersons.stream().filter(workingAgePErson).collect(Collectors.toList()));
        System.out.println("Non-Adult People List : "+listPersons.stream().filter(agePredicate18.negate()).collect(Collectors.toList()));

    }



    public static void main(String[] args) {
//        testPersonAge();
        testBiPredicate();
    }

}

class Person {
    String name;
    int age;

    Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}