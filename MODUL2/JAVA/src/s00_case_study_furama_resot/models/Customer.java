package s00_case_study_furama_resot.models;

import s00_case_study_furama_resot.commons.RegexCustomer;
import s00_case_study_furama_resot.exception.*;

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
        System.out.printf("%-5s%-15s%-25s%-17s%-12s%-17s%-30s%-18s%-25s", count, this.idCard, this.nameCustomer, this.dateOfBirth,
                this.gender, this.phoneNumber, this.email, this.typeCustomer, this.address);

    }

    public static void showInformationCustomerBooking() {
        int count = 0;
        System.out.printf("%-5s%-15s%-25s%-12s%-18s", "NO", "ID Card", "Name", "Gender", "Type Customer");
        System.out.println("\n");
        for (Customer customer : customerList) {
            System.out.printf("%-5s%-15s%-25s%-12s%-18s", ++count, customer.idCard, customer.nameCustomer, customer.gender, customer.typeCustomer);
            System.out.println("\n");
        }

    }

    public static void addNewCustomer() {
        Scanner input = new Scanner(System.in);
        Customer customer;
        String idCard = null, nameCustomer = null, dateOfBirth = null, gender = null, phoneNumber, email = null, typeCustomer, address;
        boolean check;
//input ID Card Customer.
        do {
            check = true;
            try {
                System.out.println("Enter ID Card customer: ");
                idCard = input.nextLine();
                if (!RegexCustomer.checkIDCard(idCard)) {
                    check = false;
                    throw new NameException("Id Card must be 9 digits and in the format XXX XXX XXX .");
                }
            } catch (NameException e) {
                System.err.println(e.getMessage());
            }
        } while (!check);
//input Name Customer
        do {
            check = true;
            try {
                System.out.println("Enter customer's name:");
                nameCustomer = input.nextLine();
                if (!RegexCustomer.checkNameFormat(nameCustomer)) {
                    check = false;
                    throw new IdCardException("Customer Name must capitalize the first character in each word.");
                }
            } catch (IdCardException e) {
                System.err.println(e.getMessage());
            }
        } while (!check);
//input Date Of Birth Customer
        do {
            check = true;
            try {
                System.out.println("Enter date of birth customer:");
                dateOfBirth = input.nextLine();
                if (!RegexCustomer.checkDate(dateOfBirth)) {
                    check = false;
                    throw new BirthdayException("The birth year must be > 1900 and 18 years younger than the current year correct format dd / mm / yyyy..");
                }
            } catch (BirthdayException e) {
                System.err.println(e.getMessage());
            }
        } while (!check);
//input Gender Customer
        do {
            check = true;
            try {
                System.out.println("Enter gender customer(Male, Female or Unknown):");
                gender = input.nextLine().toLowerCase();
                if (!RegexCustomer.checkGender(gender)) {
                    check = false;
                    throw new GenderException("Gender must be Male, Female or Unknown");
                }
                String data = gender.toUpperCase().charAt(0) + gender.substring(1);
                gender = data;
            } catch (GenderException e) {
                System.err.println(e.getMessage());
            }
        } while (!check);

//input Phone number
        System.out.println("Enter phone number customer: ");
        phoneNumber = RegexCustomer.checkPhone(input.nextLine());
        do {
            check = true;
            try {
                System.out.println("Enter email customer:");
                email = input.nextLine();
                if (!RegexCustomer.checkEmail(email)) {
                    check = false;
                    throw new EmailException("Email must be in abc@abc.abc format");
                }
            } catch (EmailException e) {
                System.err.println(e.getMessage());
            }
        } while (!check);
        System.out.println("Enter type customer(Diamond, Platinum, Gold, Silver, Member):");
        typeCustomer = RegexCustomer.checkType(input.nextLine().toLowerCase());
        System.out.println("Enter address customer:");
        address = RegexCustomer.checkAddress(input.nextLine().toLowerCase());
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
