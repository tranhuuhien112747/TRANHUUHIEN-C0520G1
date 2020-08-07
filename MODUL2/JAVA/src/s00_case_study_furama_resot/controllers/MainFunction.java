package s00_case_study_furama_resot.controllers;

import s00_case_study_furama_resot.commons.ReadAndWriteFile;
import s00_case_study_furama_resot.commons.RegexCustomer;
import s00_case_study_furama_resot.commons.RegexService;
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
            System.out.println(" ___________________**  MENU  **___________________ ");
            System.out.println("|                                                  |");
            System.out.println("|             1. Add New Services.                 |");
            System.out.println("|             2. Show Services.                    |");
            System.out.println("|             3. Add New Customer.                 |");
            System.out.println("|             4. Show Information of Customer.     |");
            System.out.println("|             5. Add New Booking.                  |");
            System.out.println("|             6. Show Information of Employee.     |");
            System.out.println("|             7. 4D Cinema.                        |");
            System.out.println("|             8. Employee Profile.                 |");
            System.out.println("|             9. Exit.                             |");
            System.out.println("|__________________________________________________|");
            System.out.print("Enter your choice: ");
            choose = RegexService.checkChooseMenu(input.nextLine());
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
                    buyTicketCinema4D();
                    break;
                case 8:
                    employeeProfile();
                    break;
                case 9:
                    ReadAndWriteFile.writerBooking(ReadAndWriteFile.getFileBookingPath());
                    System.exit(0);
                default:
                    System.err.println("Value not in menu. Please Enter !!!");
            }
        }
    }

    //-----------------------------------1. ADD NEW SERVICES-----------------------------------------------
    public void addNewServices() throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.println("__________Add New Services__________");
        System.out.println("                                    ");
        System.out.println("         1. Add New Villa.          ");
        System.out.println("         2. Add New House.          ");
        System.out.println("         3. Add New Room.           ");
        System.out.println("         4. Back to Menu.           ");
        System.out.println("         5. Exit.                   ");
        System.out.println("____________________________________");
        System.out.print("Enter your select: ");
        int choose = RegexService.checkChooseMenu(input.nextLine());
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
                System.out.println();
                displayMainMenu();
                break;
            case 5:
                System.exit(0);
            default:
                System.err.println("Value not in menu. Please Enter !!!");
        }
    }

    //---------------------------------------2. SHOW SERVICES--------------------------------------------
    public void showServices() throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.println("____________Show Services___________");
        System.out.println("                                    ");
        System.out.println("    1. Show all Villa.              ");
        System.out.println("    2. Show all House.              ");
        System.out.println("    3. Show all Room.               ");
        System.out.println("    4. Show all Villa Not Duplicate.");
        System.out.println("    5. Show all House Not Duplicate.");
        System.out.println("    6. Show all Room Not Duplicate. ");
        System.out.println("    7. Back to Menu.                ");
        System.out.println("    8. Exit.                        ");
        System.out.println("____________________________________");
        System.out.print("Enter your select: ");
        int choose = RegexService.checkChooseMenu(input.nextLine());
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
//                Room.showRoom();
//                System.out.println(" nhap id");
//                String id=input.nextLine();
//                Room.eDitRoom(id);
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
                System.out.println();
                displayMainMenu();
                break;
            case 8:
                System.exit(0);
            default:
                System.err.println("Value not in menu. Please Enter !!!");


        }
    }

    //---------------------------------------3. ADD NEW CUSTOMER----------------------------------------------
    public void addNewCustomer() throws IOException {
        Customer.addNewCustomer();
        ReadAndWriteFile.writerFile(ReadAndWriteFile.getFileCustomerPath());
    }

    //---------------------------------------4. SHOW INFORMATION CUSTOMER-----------------------------------
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
        System.out.println("______________________________________");
        System.out.println();
    }

    //---------------------------------------5. ADD NEW BOOKING----(Task 7)-------------------------------------------
    public void addNewBooking() throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("______________________________LIST CUSTOMER______________________________");
        Customer.showInformationCustomerBooking();
        System.out.println("_________________________________________________________________________");
        System.out.print("Select the customer you want to book :");
        int select = Integer.parseInt(input.nextLine());
        Customer customer = Customer.getCustomerList().get(select - 1);
        System.out.println("_________________________");
        System.out.println("    1. Booking Villa     ");
        System.out.println("    2. Booking House     ");
        System.out.println("    3. Booking Room      ");
        System.out.println("    4. Back to Menu      ");
        System.out.println("_________________________");
        System.out.print("Choose services: ");
        int choose = Integer.parseInt(input.nextLine());
        switch (choose) {
            case 1:
                Villa.showVilla();
                System.out.print("Choose Villa: ");
                int chooseV = Integer.parseInt(input.nextLine());
                Villa villa = Villa.getVillaList().get(chooseV - 1);
                customer.setServices(villa);
                break;
            case 2:
                House.showHouse();
                System.out.print("Choose House: ");
                int chooseH = Integer.parseInt(input.nextLine());
                House house = House.getHouseList().get(chooseH - 1);
                customer.setServices(house);
//                ReadAndWriteFile.writerBooking(ReadAndWriteFile.getFileBookingPath());
                break;
            case 3:
                Room.showRoom();
                System.out.print("Choose Room: ");
                int chooseR = Integer.parseInt(input.nextLine());
                Room room = Room.getRoomList().get(chooseR - 1);
                customer.setServices(room);
                break;
            case 4:
                System.out.println();
                displayMainMenu();
                break;
            default:
                System.err.println("Failed");
        }
    }

    //------------------------------6. SHOW INFORMATION OF EMPLOYEE-----(Task 9)------------------------------
    public static void showInformationOfEmployee() {
        Employee.showInformation();
    }

    //-----------------------------7. BUY CINEMA 4D--------------------(Task 10)-------------------------------------
    public static void buyTicketCinema4D() {
        Scanner input = new Scanner(System.in);
        System.out.println("________WELL COME TO CINEMA 4D_______ ");
        if (Cinema4D.getTicketBox() == 0) {
            System.err.println("Sorry, the ticket is over. Please come back tomorrow. Thank you");
        } else {
            System.out.println("Currently the theater has  " + Cinema4D.getTicketBox() + "  tickets.");
            int numberTicket;
            boolean check;
            do {
                check = true;
                System.out.println("How many tickets do you want to buy ?");
                numberTicket = Integer.parseInt(input.nextLine());
                if (Cinema4D.getTicketBox() < numberTicket) {
                    check = false;
                    System.err.println("The cinema has only  " + Cinema4D.getTicketBox() + " tickets left");
                }
            } while (!check);
            System.out.print("Enter name customer:");
            String name = RegexCustomer.checkAddress(input.nextLine());
            System.out.print("Enter phone number: ");
            String phone = RegexCustomer.checkPhone(input.nextLine());
            Customer customer = new Customer(name, phone);
            Cinema4D.byTicker(customer, numberTicket);
        }
    }

    //----------------------------SEARCH EMPLOYEE-------(Task 11)----------------------------------------
    public static void employeeProfile() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the code the employee wants to search:");
        String code = input.nextLine();
        FilingCabinets.searchEmployee(code);
    }
}
