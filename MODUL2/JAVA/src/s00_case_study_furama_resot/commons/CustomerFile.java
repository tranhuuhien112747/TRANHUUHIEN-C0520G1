package s00_case_study_furama_resot.commons;

import s00_case_study_furama_resot.models.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerFile {
    private static final String FILE_CUSTOMER_PATH = "E:\\TRANHUUHIEN-C0520G1\\MODUL2\\JAVA\\src\\s00_case_study_furama_resot\\data\\customer.csv";

    public static void writerFileCustomer() throws IOException {
        List<Customer> customerList = Customer.getCustomerList();
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(FILE_CUSTOMER_PATH);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Customer customer : customerList) {
                bufferedWriter.append(customer.getIdCard());
                bufferedWriter.append(",");
                bufferedWriter.append(customer.getNameCustomer());
                bufferedWriter.append(",");
                bufferedWriter.append(customer.getDateOfBirth());
                bufferedWriter.append(",");
                bufferedWriter.append(customer.getGender());
                bufferedWriter.append(",");
                bufferedWriter.append(customer.getPhoneNumber());
                bufferedWriter.append(",");
                bufferedWriter.append(customer.getEmail());
                bufferedWriter.append(",");
                bufferedWriter.append(customer.getTypeCustomer());
                bufferedWriter.append(",");
                bufferedWriter.append(customer.getAddress());
                bufferedWriter.append("\n");
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bufferedWriter.close();
            fileWriter.close();
        }
    }

    public static void readerFileCustomer() throws IOException {
        List<Customer> customerList = new ArrayList<>();
        File file = new File(FILE_CUSTOMER_PATH);
        if ((!file.exists())) {
            System.out.println("File Not Found !!!");
        } else if (file.toString() == null) {
            System.err.println("The file has no data !!");
        }
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = null;
            String[] arrayCustomer;
            while ((line = bufferedReader.readLine()) != null) {
                arrayCustomer = line.split(",");
                Customer customer = new Customer();
                customer.setIdCard(arrayCustomer[0]);
                customer.setNameCustomer(arrayCustomer[1]);
                customer.setDateOfBirth(arrayCustomer[2]);
                customer.setGender(arrayCustomer[3]);
                customer.setPhoneNumber(arrayCustomer[4]);
                customer.setEmail(arrayCustomer[5]);
                customer.setTypeCustomer(arrayCustomer[6]);
                customer.setAddress(arrayCustomer[7]);
                customerList.add(customer);
            }
            Customer.setCustomerList(customerList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            bufferedReader.close();
            fileReader.close();
        }


    }

}
