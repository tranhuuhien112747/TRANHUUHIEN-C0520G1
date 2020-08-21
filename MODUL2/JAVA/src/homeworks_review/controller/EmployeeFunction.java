package homeworks_review.controller;

import homeworks_review.commons.ReadandWriter;
import homeworks_review.commons.RegexEmployee;
import homeworks_review.exception.CodeException;
import homeworks_review.exception.DayOfBirthException;
import homeworks_review.exception.NameException;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class EmployeeFunction {
    static Scanner input = new Scanner(System.in);
    private static List<Employee> employeeList = Employee.getEmployeeList();

    public void disPlayMainMenu() throws IOException {
        while (true) {
            System.out.println();
            System.out.println("1. Add New Employee           ");
            System.out.println("2. Show Information Employee  ");
            System.out.println("3. Edit Information Employee  ");
            System.out.println("4. Search Information Employee");
            System.out.println("5. Remove Information Employee");
            System.out.println("6. Exit                       ");
            System.out.println("Enter your choose: ");
            int choose = Integer.parseInt(input.nextLine());
            switch (choose) {
                case 1:
                    addNewEmployee();
                    ReadandWriter.writeEmployee();
                    break;
                case 2:
                    showInformation();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                default:
                    System.err.println("Value not in menu. Please Enter !!!");
            }
        }
    }

    //------------------------1. ADD NEW EMPLOYEE----------------------------------
    public static void addNewEmployee() {
        String code = null, name = null, address = null, workingParts = null, dateOfBirth = null;
        double salary;
        boolean check;
        //----input code.
        do {
            check = true;
            try {
                System.out.println("Enter code employee: ");
                code = input.nextLine();
                if (!RegexEmployee.checkCodeEmployee(code)) {
                    check = false;
                    throw new CodeException("The code is of the form XXX- (A-Z)");
                }
                for (int i = 0; i < employeeList.size(); i++) {
                    if (code.equals(employeeList.get(i).getCode())) {
                        System.err.println("The code is already in the list");
                        check = false;
                        break;
                    }
                }
            } catch (CodeException e) {
                e.printStackTrace();
            }
        } while (!check);

        //----input name.
        do {
            check = true;
            try {
                System.out.println("Enter Name employee:");
                name = input.nextLine();
                if (!RegexEmployee.checkNameEmployee(name)) {
                    check = false;
                    throw new NameException("Employee names must be capitalized first letter");
                }
            } catch (NameException e) {
                e.printStackTrace();
            }
        } while (!check);

//------input day of birth
        do {
            check = true;
            try {
                System.out.println("Enter day of birth of employee:");
                dateOfBirth = input.nextLine();
                if (!RegexEmployee.checkDate(dateOfBirth)) {
                    check = false;
                    throw new DayOfBirthException();
                }
            } catch (DayOfBirthException e) {
                e.printStackTrace();
            }
        } while (!check);

        //--------input workingParts
        System.out.println("Enter Working Parts employee");
        workingParts = input.nextLine();
        System.out.println("Enter salary");
        salary = Double.parseDouble(input.nextLine());
        System.out.println("Enter Address");
        address = input.nextLine();
        System.out.println("SUCCESS!!!");
        Employee employee = new Employee(code, name, dateOfBirth, workingParts, salary, address);
        employeeList.add(employee);
    }

    public static void showInformation() {
        Employee.showInformationEmployee();
    }

}
