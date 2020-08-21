package homeworks_review.controller;

import homeworks_review.commons.SortByYear;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Employee {
    private String code;
    private String name;
    private String dateOfBirth;
    private String address;
    private String workingParts;
    private double salary;
    private static List<Employee> employeeList = new ArrayList<>();

    public Employee() {
    }

    public Employee(String code, String name, String dateOfBirth, String workingParts, double salary, String address) {
        this.code = code;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.workingParts = workingParts;
        this.salary = salary;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWorkingParts() {
        return workingParts;
    }

    public void setWorkingParts(String workingParts) {
        this.workingParts = workingParts;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public static List<Employee> getEmployeeList() {
        return employeeList;
    }

    public static void setEmployeeList(List<Employee> employeeList) {
        Employee.employeeList = employeeList;
    }

    public String getYear(String dateOfBirth) {
        String[] array = dateOfBirth.split("/");
        return array[2];
    }

    public String getNameSort(String nameEmployee) {
        String[] array = nameEmployee.split(" ");
        return array[array.length - 1];
    }

    public static void showInformationEmployee() {
        Collections.sort(employeeList, new SortByYear());
        System.out.printf("%-8s%-25s%-17s%-25s%-17S%-25s", "CODE", "NAME EMPLOYEE", "Date Of Birth", "PARTS", "SALARY", "ADDRESS");
        System.out.println();
        for (Employee employee : employeeList) {
            System.out.printf("%-8s%-25s%-17s%-25s%-17.3f%-25s", employee.code, employee.name, employee.dateOfBirth, employee.workingParts
                    , employee.salary, employee.address);
            System.out.println();
        }
        System.out.println();
    }

}
