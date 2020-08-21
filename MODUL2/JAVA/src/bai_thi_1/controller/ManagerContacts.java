package bai_thi_1.controller;

import s00_case_study_furama_resot.commons.RegexCustomer;
import s00_case_study_furama_resot.exception.EmailException;
import s00_case_study_furama_resot.exception.GenderException;
import s00_case_study_furama_resot.exception.IdCardException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerContacts {
    private String name;
    private String gender;
    private String phoneNumber;
    private String group;
    private String address;
    private String email;
    private static List<ManagerContacts> managerContactsList = new ArrayList<>();

    public ManagerContacts() {
    }

    public ManagerContacts(String name, String gender, String phoneNumber, String group, String address, String email) {
        this.name = name;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.group = group;
        this.address = address;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static List<ManagerContacts> getManagerContactsList() {
        return managerContactsList;
    }

    public static void setManagerContactsList(List<ManagerContacts> managerContactsList) {
        ManagerContacts.managerContactsList = managerContactsList;
    }


    public void showInformation() {
        for (ManagerContacts contacts : managerContactsList) {
            System.out.printf("%-25s%-15s%-15s%-15s%-20s%-25s", contacts.name, contacts.gender, contacts.phoneNumber,
                    contacts.group, contacts.address, contacts.email);
            System.out.println();
        }
    }

    public void addNewContacts() {
        ManagerContacts managerContacts;
        String name, gender, phoneNumber, group, address, email;
        Scanner input = new Scanner(System.in);
        boolean check;
        System.out.println("Enter name:");
        name = input.nextLine();
        System.out.println("Enter gender name (Male, Female or Unknown):");
        gender = input.nextLine();
        do {
            check = true;
            System.out.println("Enter number Phone:");
            phoneNumber = input.nextLine();
            if (!RegexContact.checkPhone(phoneNumber)) {
                check = false;
                System.err.println("Phone number is not format");
            }
        } while (!check);
        System.out.println("Enter group:");
        group = input.nextLine();
        System.out.println("Enter Address:");
        address = input.nextLine();
        do {
            check = true;
            System.out.println("Enter email :");
            email = input.nextLine();
            if (!RegexContact.checkEmail(email)) {
                check = false;
                System.err.println("Email must be in abc@abc.abc format");
            }
        } while (!check);
        managerContacts = new ManagerContacts(name, gender, phoneNumber, group, address, email);
        managerContactsList.add(managerContacts);
        showInformation();
    }

}
