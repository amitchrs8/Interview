package Basics.collections;

import com.sun.istack.internal.NotNull;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class ArrayListDemo {

    private static void testConcurrentModificationException1(){
        List<String> listStr = new ArrayList<>();
        listStr.add("First");
        listStr.add("Second");
        listStr.add("Third");
        listStr.add("Fourth");

        for (String st : listStr){
            System.out.println(st);
            if ("Third".equals(st)){
                listStr.add("Fifth");
                listStr.remove("Fourth");
            }
        }

    }

    private static void testConcurrentModificationException2(){
        System.out.println("Using ArrayList ");
        List<String> listStr = new ArrayList<>();
        listStr.add("First");
        listStr.add("Second");
        listStr.add("Third");
        listStr.add("Fourth");

        Iterator<String> itrStr = listStr.iterator();
        while(itrStr.hasNext()){
            String s = itrStr.next();
            System.out.println(s);
            if("Third".equals(s)){
                itrStr.remove();
            }
        }

        System.out.println(listStr);
    }

    private static void testCopyOnWriteArraylist(){
        System.out.println("Using CopyOnWriteArrayList ");
        List<String> listStr = new CopyOnWriteArrayList<>();
        listStr.add("First");
        listStr.add("Second");
        listStr.add("Third");
        listStr.add("Fourth");

        Iterator<String> itrStr = listStr.iterator();
        while(itrStr.hasNext()){
            String s = itrStr.next();
            System.out.println(s);
            if("Third".equals(s)){
                listStr.remove("Third");
            }
        }
        System.out.println(listStr);
    }

    private static void testListIterator(){
        System.out.println("Using ListIterator ");
        List<String> listStr = new ArrayList<>();
        listStr.add("First");
        listStr.add("Second");
        listStr.add("Third");
        listStr.add("Fourth");
        System.out.println(listStr);
        ListIterator<String> listIter = listStr.listIterator();

        System.out.println("Traversing forward");
        while(listIter.hasNext()){
            System.out.println(listIter.next());
        }

        System.out.println("Traversing backward");
        while(listIter.hasPrevious()){
            System.out.println(listIter.previous());
        }

    }

    private static void sortArraylist(){

        List<String> listStr = new ArrayList<>();
        listStr.add("First");
        listStr.add("Second");
        listStr.add("Third");
        listStr.add("Fourth");
        System.out.println("Before Sort : "+listStr);
//        Collections.sort(listStr);


        Collections.sort(listStr, (o1, o2) -> {
            return o2.compareTo(o1);
        });

        System.out.println("After Sort : "+listStr);

    }

    private static void testCustomObjectCompare(){

        Employee emp1 = new Employee("Test1", 1,3233100320L);
        Employee emp2 = new Employee("Test2", 121,1231000L);
        Employee emp3 = new Employee("Test3", 41,10031230L);
        Employee emp4 = new Employee("Test4", 152,540310312L);

        List<Employee> listEpm = new ArrayList<>();
        listEpm.add(emp1);
        listEpm.add(emp2);
        listEpm.add(emp3);
        listEpm.add(emp4);

        listEpm.stream().filter(e-> e.getEmpSalary() > 1000L).collect(Collectors.toList());

        Collections.sort(listEpm);
        System.out.println("After default comparable sorting!!!");
        for (Employee employee : listEpm) {
            System.out.println(employee);
        }
        Collections.sort(listEpm, (o1,o2)->{
            return o1.getEmpId().compareTo(o2.getEmpId());
        });
        System.out.println("After ID based comparator sorting!!!");
        for (Employee employee : listEpm) {
            System.out.println(employee);
        }

        Collections.sort(listEpm, (o1,o2)->{
            return o1.getEmpSalary().compareTo(o2.getEmpSalary());
        });
        System.out.println("After Salary based comparator sorting!!!");
        for (Employee employee : listEpm) {
            System.out.println(employee);
        }


    }


    public static void main(String[] args) {
//        testConcurrentModificationException1();
//        testConcurrentModificationException2();
//        testCopyOnWriteArraylist();
//        testListIterator();
//        sortArraylist();
        testCustomObjectCompare();
    }
}



class Employee implements Comparable<Employee> {

    private String empName;
    private Integer empId;
    private Long empSalary;

    public Employee(String empName, Integer empId, Long empSalary){
        this.empName = empName;
        this.empId = empId;
        this.empSalary = empSalary;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Long getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(Long empSalary) {
        this.empSalary = empSalary;
    }

    @Override
    public int compareTo(@NotNull Employee emp){
        return emp.getEmpName().compareTo(this.getEmpName());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empName='" + empName + '\'' +
                ", empId=" + empId +
                ", empSalary=" + empSalary +
                '}';
    }
}