package s00_case_study_furama_resot.models;

import java.util.Scanner;
import java.util.Stack;


public class FilingCabinets {
    private static Stack<Employee> employeeStack = new Stack<>();

    public static void profileList() {
        for (Employee employee : Employee.getEmployeeList().values()) {
            employeeStack.push(employee);
        }
    }

    public static void searchEmployee(String code) {
        boolean check = false;
        profileList();
        while (!employeeStack.isEmpty()) {
            if (code.equals(employeeStack.peek().getCodeEmployee())) {
                check = true;
                break;
            } else {
                employeeStack.pop();
            }
        }
        if (check) {
            System.out.printf("%-7s%-25s%-6s%-20s", "CODE", "NAME", "AGE", "ADDRESS");
            System.out.println();
            System.out.printf("%-7s%-25s%-6s%-20s", "----", "--------------", "---", "-------");
            System.out.println();
            System.out.println(employeeStack.peek().toString());
        } else {
            System.err.println("Not Found !!!");
        }
        System.out.println();
    }

}
