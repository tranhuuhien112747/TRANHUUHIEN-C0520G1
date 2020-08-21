package homeworks_review.commons;

import homeworks_review.controller.Employee;

import java.io.*;
import java.util.List;

public class ReadandWriter {
    static final String FILE_PATH = "E:\\TRANHUUHIEN-C0520G1\\MODUL2\\JAVA\\src\\homeworks_review\\data\\employee.csv";
    static List<Employee> employeeList = Employee.getEmployeeList();

    public static void writeEmployee() throws IOException {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            System.err.println("File Not Found!!!1");
        }
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Employee employee : employeeList) {
                bufferedWriter.append(employee.getCode());
                bufferedWriter.append(",");
                bufferedWriter.append(employee.getName());
                bufferedWriter.append(",");
                bufferedWriter.append(employee.getDateOfBirth());
                bufferedWriter.append(",");
                bufferedWriter.append(employee.getWorkingParts());
                bufferedWriter.append(",");
                bufferedWriter.append(String.valueOf(employee.getSalary()));
                bufferedWriter.append(",");
                bufferedWriter.append(employee.getAddress());
                bufferedWriter.append("\n");
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bufferedWriter.close();
        }
    }

    public static void readerEmployee() throws IOException {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            System.err.println("Failed1!!1");
        }
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = null;
            String[] dataEmploy;
            while ((line = bufferedReader.readLine()) != null) {
                if ("".equals(line)) {
                    break;
                } else {
                    dataEmploy = line.split(",");
                    String code = dataEmploy[0];
                    String name = dataEmploy[1];
                    String date = dataEmploy[2];
                    String parts = dataEmploy[3];
                    double salary = Double.parseDouble(dataEmploy[4]);
                    String address = dataEmploy[5];
                    Employee employee = new Employee(code, name, date, parts, salary, address);
                    employeeList.add(employee);
                    Employee.setEmployeeList(employeeList);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bufferedReader.close();
        }
    }
}
