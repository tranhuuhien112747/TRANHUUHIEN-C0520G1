package s00_case_study_furama_resot.models;

import s00_case_study_furama_resot.commons.RegexCustomer;

import java.util.*;

/**
 * Create a class named Customer with the following properties: Customer name, Date of birth, Gender, ID card number,
 * Phone number, Email, Guest type, Address and attribute using the service whose object type is Services, and showInformation() method.
 */

public class Customer implements Comparable<Customer> {
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


    public void showInformationCustomer(int count) {
        System.out.printf("%-5s%-15s%-25s%-17s%-12s%-16s%-30s%-18s%-25s", count, this.idCard, this.nameCustomer, this.dateOfBirth,
                this.gender, this.phoneNumber, this.email, this.typeCustomer, this.address);

    }

    public static void addNewCustomer() {
        Scanner input = new Scanner(System.in);
        Customer customer;
        String idCard, nameCustomer, dateOfBirth, gender, phoneNumber, email, typeCustomer, address;
        System.out.println("Enter ID Card customer: ");
        idCard = RegexCustomer.checkIDCard(input.nextLine());
        System.out.println("Enter customer's name:");
        nameCustomer = RegexCustomer.checkNameFormat(input.nextLine());
        System.out.println("Enter date of birth customer:");
        dateOfBirth = RegexCustomer.checkDate(input.nextLine());
        System.out.println("Enter gender customer(Male, Female or Unknown):");
        gender = RegexCustomer.checkGender(input.nextLine());
        System.out.println("Enter phone number customer: ");
        phoneNumber = RegexCustomer.checkPhone(input.nextLine());
        System.out.println("Enter email customer:");
        email = RegexCustomer.checkEmail(input.nextLine());
        System.out.println("Enter type customer(Diamond, Platinum, Gold, Silver, Member):");
        typeCustomer = RegexCustomer.checkType(input.nextLine());
        System.out.println("Enter address customer:");
        address = input.nextLine();
        System.out.println("ENTER THE INFORMATION SUCCESSFULLY !");
        customer = new Customer(idCard, nameCustomer, dateOfBirth, gender, phoneNumber, email, typeCustomer, address);
        customerList.add(customer);
    }

    public String getNameSort(String nameCustomer) {
        String[] array = nameCustomer.split(" ");
        return array[array.length - 1];
    }

    public String getYear(String dateOfBirth) {
        String[] array = dateOfBirth.split("/");
        return array[2];
    }


    @Override
    public int compareTo(Customer customer) {
        int result = this.getNameSort(this.nameCustomer).compareTo(customer.getNameSort(customer.nameCustomer));
        if (result == 0) {
            return Integer.compare(Integer.parseInt(this.getYear(this.dateOfBirth)), Integer.parseInt(customer.getYear(customer.dateOfBirth)));
        }
        return result;
    }

}
