package s00_case_study_furama_resot.controllers;

import s00_case_study_furama_resot.commons.ReadAndWriteFile;
import s00_case_study_furama_resot.models.*;

import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;

public class MainFunction {
    public void readAllFile() throws IOException {
        ReadAndWriteFile.readFileCustomer(ReadAndWriteFile.getFileCustomerPath());
        ReadAndWriteFile.readFile(ReadAndWriteFile.getFileVillaPath());
        ReadAndWriteFile.readFile(ReadAndWriteFile.getFileHousePath());
        ReadAndWriteFile.readFile(ReadAndWriteFile.getFileRoomPath());
        ReadAndWriteFile.readFileEmployee(ReadAndWriteFile.getFileEmployeePath());
    }

    public void displayMainMenu() throws IOException {
        Scanner input = new Scanner(System.in);
        int choose;
        while (true) {
            System.out.println("\n");
            System.out.println("******************~*-MENU-*~*********************");
            System.out.println("1. Add New Services.");
            System.out.println("2. Show Services.");
            System.out.println("3. Add New Customer.");
            System.out.println("4. Show Information of Customer.");
            System.out.println("5. Add New Booking.");
            System.out.println("6. Show Information of Employee.");
            System.out.println("7. Exit.");
            System.out.println("-------------------------------------------------");
            System.out.print("Enter your choice: ");
            choose = input.nextInt();
            switch (choose) {
                case 1:
                    addNewServices();
                    break;
                case 2:
                    showServices();
                    break;
                case 3:
                    addNewCustomer();
                    break;
                case 4:
                    showInformationOfCustomer();
                    break;
                case 5:
                    addNewBooking();
                    break;
                case 6:
                    showInformationOfEmployee();
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Invalid value!!!");
            }
        }
    }

    //-----------------------------------1. ADD NEW SERVICES---------------------------
    public void addNewServices() throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("1. Add New Villa.");
        System.out.println("2. Add New House.");
        System.out.println("3. Add New Room.");
        System.out.println("4. Back to Menu.");
        System.out.println("5. Exit.");
        System.out.print("Enter your select: ");
        int choose = input.nextInt();
        switch (choose) {
            case 1:
                Villa villa = new Villa();
                villa.addNewVilla();
                ReadAndWriteFile.writerFile(ReadAndWriteFile.getFileVillaPath());
                break;
            case 2:
                House house = new House();
                house.addNewHouse();
                ReadAndWriteFile.writerFile(ReadAndWriteFile.getFileHousePath());
                break;
            case 3:
                Room room = new Room();
                room.addNewRoom();
                ReadAndWriteFile.writerFile(ReadAndWriteFile.getFileRoomPath());
                break;
            case 4:
                displayMainMenu();
                break;
            case 5:
                System.exit(0);
            default:
                System.err.println("Invalid value.");
        }
    }

    //---------------------------------------2. SHOW SERVICES------------------------------
    public void showServices() throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("1. Show all Villa.");
        System.out.println("2. Show all House.");
        System.out.println("3. Show all Room.");
        System.out.println("4. Show all Villa Not Duplicate.");
        System.out.println("5. Show all House Not Duplicate.");
        System.out.println("6. Show all Room Not Duplicate.");
        System.out.println("7. Back to Menu.");
        System.out.println("8. Exit.");
        System.out.print("Enter your select: ");
        int choose = input.nextInt();
        switch (choose) {
            case 1:
                Villa villa = new Villa();
                villa.showInformation();
                break;
            case 2:
                House house = new House();
                house.showInformation();
                break;
            case 3:
                Room room = new Room();
                room.showInformation();
                break;
            case 4:
                Villa.showAllNameVillaNotDuplicate();
                break;
            case 5:
                House.showAllNameHouseNotDuplicate();
                break;
            case 6:
                Room.showAllNameRoomNotDuplicate();
                break;
            case 7:
                displayMainMenu();
                break;
            case 8:
                System.exit(0);
            default:
                System.err.println("Invalid value.");


        }
    }

    //---------------------------------------3. ADD NEW CUSTOMER---------------------
    public void addNewCustomer() throws IOException {
        Customer.addNewCustomer();
        ReadAndWriteFile.writerFile(ReadAndWriteFile.getFileCustomerPath());
    }

    //---------------------------------------4. SHOW INFORMATION CUSTOMER------------
    public void showInformationOfCustomer() {
        Collections.sort(Customer.getCustomerList());
        System.out.printf("%-5s%-15s%-25s%-17s%-12s%-17s%-30s%-18s%-25s", "NO", "ID Card", "Name Customer", "Date Of Birth", "Gender",
                "Phone number", "Email Customer", "Type Customer", "Address");
        System.out.println("\n");
        int count = 0;
        for (Customer customer : Customer.getCustomerList()) {
            customer.showInformationCustomer(++count);
            System.out.println("\n");
        }
    }

    //---------------------------------------5. ADD NEW BOOKING-----------------------
    public void addNewBooking() throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("-----------------------------LIST CUSTOMER------------------------------------");
        Customer.showInformationCustomerBooking();
        System.out.println("\n");
        System.out.println("Select the customer you want to book :");
        int select = Integer.parseInt(input.nextLine());
        Customer customer = Customer.getCustomerList().get(select - 1);
        System.out.println("Choose services: ");
        System.out.println("1. Booking Villa");
        System.out.println("2. Booking House");
        System.out.println("3. Booking Room");
        System.out.println("4. Back to Menu");
        int choose = Integer.parseInt(input.nextLine());
        switch (choose) {
            case 1:
                Villa.showVilla();
                System.out.println("Choose Villa: ");
                int chooseV = Integer.parseInt(input.nextLine());
                Villa villa = Villa.getVillaList().get(chooseV - 1);
                customer.setServices(villa);
                ReadAndWriteFile.writerBooking(ReadAndWriteFile.getFileBookingPath());
                break;
            case 2:
                House.showHouse();
                System.out.println("Choose House");
                int chooseH = Integer.parseInt(input.nextLine());
                House house = House.getHouseList().get(chooseH - 1);
                customer.setServices(house);
                ReadAndWriteFile.writerBooking(ReadAndWriteFile.getFileBookingPath());
                break;
            case 3:
                Room.showRoom();
                System.out.println("Choose Room");
                int chooseR = Integer.parseInt(input.nextLine());
                Room room = Room.getRoomList().get(chooseR - 1);
                customer.setServices(room);
                ReadAndWriteFile.writerBooking(ReadAndWriteFile.getFileBookingPath());
                break;
            case 4:
                displayMainMenu();
                break;
            default:
                System.err.println("Failed");
        }
    }

    //--------------------------------SHOW INFORMATION OF EMPLOYEE----------------------
    public static void showInformationOfEmployee() {
        Employee.showInformation();
    }
}
