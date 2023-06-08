package Basics.collections;

import java.util.TreeSet;

public class TreeSetDemo {


    private static void testTreeSetDemo(){

        TreeSet<EmployeeT> tset = new TreeSet<>((o1,o2)-> o1.getEmpId().compareTo(o2.getEmpId()));
        EmployeeT emp1 = new EmployeeT("Test121",321);
        EmployeeT emp2 = new EmployeeT("Rqmf21",54);
        EmployeeT emp3 = new EmployeeT("Pdffa43",756);
        EmployeeT emp4 = new EmployeeT("Modasn",6922);

        tset.add(emp1);
        tset.add(emp2);
        tset.add(emp3);
        tset.add(emp4);

        tset.stream().forEach(System.out::println);

    }

    public static void main(String[] args) {
        testTreeSetDemo();
    }
}

class EmployeeT implements Comparable<EmployeeT>{

    private String empName;
    private Integer empId;

    public EmployeeT(String empName, Integer empID){
        this.empName = empName;
        this.empId = empID;
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

    @Override
    public String toString() {
        return "EmployeeT{" +
                "empName='" + empName + '\'' +
                ", empId=" + empId +
                '}';
    }

    @Override
    public int compareTo(EmployeeT o) {
        return this.empName.compareTo(o.empName);
    }
}
