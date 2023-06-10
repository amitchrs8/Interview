package java_8;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorsDemo {
    private static void testGrouping() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Alex", 23, 23000, "USA"));
        employeeList.add(new Employee("Ben", 63, 25000, "China"));
        employeeList.add(new Employee("Dave", 34, 56000, "India"));
        employeeList.add(new Employee("Jodi", 43, 67000, "USA"));
        employeeList.add(new Employee("Ryan", 53, 54000, "China"));

        Map<String, List<Employee>> empMap = employeeList.stream().collect(Collectors.groupingBy(Employee::getCountry));
        System.out.println("Employee Map by Country");
        System.out.println(empMap);

        Map<String, Set<Employee>> empSet = employeeList.stream().collect(Collectors.groupingBy(Employee::getCountry,Collectors.toSet()));
        System.out.println("Employee set by Country");
        System.out.println(empSet);

        // The employees are grouped by country and age by using the groupingBy() method twice.
        Map<String,Map<Integer,List<Employee>>> empAgeMap = employeeList.stream().collect(Collectors.groupingBy(Employee::getCountry,Collectors.groupingBy(Employee::getAge)));
        System.out.println("Employee Map by Country and Age");
        System.out.println(empAgeMap);

        //Map where the key is the name of the country and the value is the sum of salaries of all of the employees of that country.
        Map<String,Integer> empSalaryMap = employeeList.stream().collect(Collectors.groupingBy(Employee::getCountry,Collectors.summingInt(Employee::getSalary)));
        System.out.println("Employee Map by Country and Salary Sum");
        System.out.println(empSalaryMap);

        // Map where the key is the name of the country and the value is the Employee object that has the max salary in that country.
        Map<String, Optional<Employee>> empMaxSalaryMap = employeeList.stream().collect(Collectors.groupingBy(Employee::getCountry,Collectors.maxBy(Comparator.comparingInt(Employee::getSalary))));
        System.out.println("Employee Map with Max Salary");
        System.out.println(empMaxSalaryMap);

        // Partitioning the list based on age.
        Map<Boolean,List<Employee>> empMapAgeAbove30 = employeeList.stream().collect(Collectors.partitioningBy(emp->emp.getAge()>30));
        System.out.println("Employee Map for Employee aged over 30 ");
        System.out.println(empMapAgeAbove30.get(Boolean.TRUE));
    }
    public static void main(String[] args) {
        testGrouping();
    }


}


class Employee {
    String name;
    int age;
    int salary;
    String country;

    Employee(String name, int age, int salary, String country) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}