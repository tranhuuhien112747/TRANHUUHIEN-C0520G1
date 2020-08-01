package s00_case_study_furama_resot.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Create a class named Customer with the following properties: Customer name, Date of birth, Gender, ID card number,
 * Phone number, Email, Guest type, Address and attribute using the service whose object type is Services, and showInformation() method.
 */

public class Customer {
    private String idCard;
    private String nameCustomer;
    private String dateOfBirth;
    private String gender;
    private String phoneNumber;
    private String email;
    private String typeCustomer;
    private String address;
    private Services services;
    private static List<Customer> customerList = new ArrayList<>();

    public Customer() {
    }

    public Customer(String idCard, String nameCustomer, String dateOfBirth, String gender, String phoneNumber,
                    String email, String typeCustomer, String address) {
        this.idCard = idCard;
        this.nameCustomer = nameCustomer;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.typeCustomer = typeCustomer;
        this.address = address;
    }

    public static List<Customer> getCustomerList() {
        return customerList;
    }

    public static void setCustomerList(List<Customer> customerList) {
        Customer.customerList = customerList;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public void showInformationCustomer() {
        System.out.printf("%-15s%-25s%-17s%-12s%-16s%-30s%-18s%-25s", this.idCard, this.nameCustomer, this.dateOfBirth,
                this.gender, this.phoneNumber, this.email, this.typeCustomer, this.address);

    }

    public static void addNewCustomer() {
        Scanner input = new Scanner(System.in);
        Customer customer;
        String idCard, nameCustomer, dateOfBirth, gender, phoneNumber, email, typeCustomer, address;
        System.out.println("Enter ID Card customer: ");
        idCard = input.nextLine();
        System.out.println("Enter customer's name:");
        nameCustomer = input.nextLine();
        System.out.println("Enter date of birth customer:");
        dateOfBirth = input.nextLine();
        System.out.println("Enter gender customer:");
        gender = input.nextLine();
        System.out.println("Enter phone number customer: ");
        phoneNumber = input.nextLine();
        System.out.println("Enter email customer:");
        email = input.nextLine();
        System.out.println("Enter type customer:");
        typeCustomer = input.nextLine();
        System.out.println("Enter address customer:");
        address = input.nextLine();
        System.out.println("ENTER THE INFORMATION SUCCESSFULLY !");
        customer = new Customer(idCard, nameCustomer, dateOfBirth, gender, phoneNumber, email, typeCustomer, address);
        customerList.add(customer);
        customer.showInformationCustomer();
    }


}
