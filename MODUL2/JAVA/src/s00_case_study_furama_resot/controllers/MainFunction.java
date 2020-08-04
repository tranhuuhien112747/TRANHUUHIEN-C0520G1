package s00_case_study_furama_resot.controllers;

import s00_case_study_furama_resot.commons.ReadAndWriteFile;
import s00_case_study_furama_resot.models.Customer;
import s00_case_study_furama_resot.models.House;
import s00_case_study_furama_resot.models.Room;
import s00_case_study_furama_resot.models.Villa;

import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;

public class MainFunction {
    public void displayMainMenu() throws IOException {
        ReadAndWriteFile.readFileCustomer(ReadAndWriteFile.getFileCustomerPath());
//        ReadAndWriteFile.readFile(ReadAndWriteFile.getFileVillaPath());
//        ReadAndWriteFile.readFile(ReadAndWriteFile.getFileHousePath());
//        ReadAndWriteFile.readFile(ReadAndWriteFile.getFileRoomPath());
        Scanner input = new Scanner(System.in);
        int choose;
        while (true) {
            System.out.println("\n");
            System.out.println("Menu");
            System.out.println("1. Add New Services.");
            System.out.println("2. Show Services.");
            System.out.println("3. Add New Customer.");
            System.out.println("4. Show Information of Customer.");
            System.out.println("5. Add New Booking.");
            System.out.println("6. Show Information of Employee.");
            System.out.println("7. Exit.");
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
                    break;
                case 6:
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Invalid value!!!");
            }
        }
    }

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
                System.out.printf("%-15s%-20s%-20s%-20s%-15s%-15s%-20s%-25s%-20s%-15s", "ID", "SERVICES",
                        "AREA USED", "RENTAL COSTS", "PEOPLE", "TYPE RENT", "STANDARD ROOM",
                        "DESCRIPTION", "AREA POOL", "FLOORS");
                System.out.println("\n");
                for (Villa villa : Villa.getVillaList()) {
                    villa.showInformation();
                    System.out.println("\n");
                }
                break;
            case 2:
                System.out.printf("%-15s%-20s%-20s%-20s%-15s%-15s%-20s%-25s%-15s", "ID", "SERVICES",
                        "AREA USED", "RENTAL COSTS", "PEOPLE", "TYPE RENT", "STANDARD ROOM",
                        "DESCRIPTION", "FLOORS");
                System.out.println("\n");
                for (House house : House.getHouseList()) {
                    house.showInformation();
                    System.out.println("\n");
                }
                break;
            case 3:
                System.out.printf("%-15s%-20s%-20s%-20s%-15s%-15s%-20s", "ID", "SERVICES",
                        "AREA USED", "RENTAL COSTS", "PEOPLE", "TYPE RENT", "SERVICES FREE");
                System.out.println("\n");
                for (Room room : Room.getRoomList()) {
                    room.showInformation();
                    System.out.println("\n");
                }
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                System.exit(0);
            default:
                System.err.println("Invalid value.");


        }
    }

    public void addNewCustomer() throws IOException {
        Customer.addNewCustomer();
        ReadAndWriteFile.writerFile(ReadAndWriteFile.getFileCustomerPath());
    }

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

}
