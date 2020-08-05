package s00_case_study_furama_resot.models;

import java.util.Map;
import java.util.TreeMap;

public class Employee {
    private String codeEmployee;
    private String nameEmployee;
    private int ageEmployee;
    private String address;
    private static Map<String, Employee> employeeList = new TreeMap<>();

    public Employee(String codeEmployee, String nameEmployee, int ageEmployee, String address) {
        this.codeEmployee = codeEmployee;
        this.nameEmployee = nameEmployee;
        this.ageEmployee = ageEmployee;
        this.address = address;
    }

    public String getCodeEmployee() {
        return codeEmployee;
    }

    public void setCodeEmployee(String codeEmployee) {
        this.codeEmployee = codeEmployee;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public int getAgeEmployee() {
        return ageEmployee;
    }

    public void setAgeEmployee(int ageEmployee) {
        this.ageEmployee = ageEmployee;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static Map<String, Employee> getEmployeeList() {
        return employeeList;
    }

    public static void setEmployeeList(Map<String, Employee> employeeList) {
        Employee.employeeList = employeeList;
    }

    @Override
    public String toString() {
        return String.format("%-7s%-25s%-6d%s", this.codeEmployee, this.nameEmployee, this.ageEmployee, this.address);
    }

    public static void showInformation() {
        System.out.printf("%-7s%-25s%-6s%-20s", "CODE", "NAME", "AGE", "ADDRESS");
        System.out.println();
        System.out.printf("%-7s%-25s%-6s%-20s", "----", "--------------", "---", "-------");
        System.out.println();
        for (Map.Entry<String, Employee> entry : employeeList.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
