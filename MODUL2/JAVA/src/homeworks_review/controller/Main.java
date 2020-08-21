package homeworks_review.controller;

import homeworks_review.commons.ReadandWriter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        EmployeeFunction employeeFunction = new EmployeeFunction();
        ReadandWriter.readerEmployee();
        employeeFunction.disPlayMainMenu();
    }
}
