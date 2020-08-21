package bai_thi_1.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Function {
    public void displayMainMenu() throws IOException {
        Scanner input = new Scanner(System.in);
        int choose;
        while (true) {
            System.out.println(" ____________**  Manager Contact  **_______________ ");
            System.out.println("|                                                  |");
            System.out.println("|             1. Show List Contact                 |");
            System.out.println("|             2. Add New Contact                   |");
            System.out.println("|             3. Edit Contact                      |");
            System.out.println("|             4. Remove Contact                    |");
            System.out.println("|             5. Search Contact                    |");
            System.out.println("|             6. Read File                         |");
            System.out.println("|             7. Writer File                       |");
            System.out.println("|             8. Exit                              |");
            System.out.println("|__________________________________________________|");
            System.out.print("Enter your choice: ");
            choose = Integer.parseInt(input.nextLine());
            switch (choose) {
                case 1:
                    ManagerContacts managerContacts = new ManagerContacts();
                    managerContacts.showInformation();
                    break;
                case 2:
                    ManagerContacts managerContacts1 = new ManagerContacts();
                    managerContacts1.addNewContacts();
                    break;
                case 3:
                    eDitContacts();
                    break;
                case 4:
                    removeContacts();
                    break;
                case 5:
                    searchContacts();
                    break;
                case 6:
                    System.out.println("Do you want to save the file (yes/no)?");
                    char answer = input.nextLine().charAt(0);
                    if (answer == 'y') {
                        ReadAndWriterContacts.readFile();
                        System.out.println("Success!!");
                    } else {
                        displayMainMenu();
                    }
                    break;
                case 7:
                    System.out.println("Do you want to update the file (yes/no)?");
                    char reply = input.nextLine().charAt(0);
                    if (reply == 'y') {
                        ReadAndWriterContacts.writerFile();
                        System.out.println("Success!!");
                    } else {
                        displayMainMenu();
                    }
                    break;
                case 8:
                    System.exit(0);
                default:
                    System.err.println();
            }
        }
    }

    public void eDitContacts() throws IOException {
        Scanner input = new Scanner(System.in);
        boolean check = false;
        System.out.println("Enter number Phone you want to edit");
        String numberPhone = input.nextLine();
        for (ManagerContacts contacts : ManagerContacts.getManagerContactsList()) {
            if (numberPhone.equals(contacts.getPhoneNumber())) {
                System.out.println("Enter name:");
                contacts.setName(input.nextLine());
                System.out.println("Enter gender name (Male, Female or Unknown):");
                contacts.setGender(input.nextLine());
                do {
                    String phoneNumber;
                    check = true;
                    System.out.println("Enter number Phone:");
                    phoneNumber = input.nextLine();
                    if (!RegexContact.checkPhone(phoneNumber)) {
                        check = false;
                        System.err.println("Phone number is not format");
                    }
                    contacts.setPhoneNumber(phoneNumber);
                } while (!check);
                System.out.println("Enter group:");
                contacts.setGroup(input.nextLine());
                System.out.println("Enter Address:");
                contacts.setAddress(input.nextLine());
                do {
                    String email;
                    check = true;
                    System.out.println("Enter email :");
                    email = input.nextLine();
                    if (!RegexContact.checkEmail(email)) {
                        check = false;
                        System.err.println("Email must be in abc@abc.abc format");
                    }
                    contacts.setEmail(email);
                } while (!check);
                check = true;
                break;
            }
        }
        if (!check) {
            System.err.println("Not Find Phone number");
        }
    }

    public void removeContacts() throws IOException {
        Scanner input = new Scanner(System.in);
        boolean check = false;
        ManagerContacts data = null;
        System.out.println("Enter number Phone you want to remove");
        String numberPhone = input.nextLine();
        for (ManagerContacts contacts : ManagerContacts.getManagerContactsList()) {
            if (numberPhone.equals(contacts.getPhoneNumber())) {
                data = contacts;
                check = true;
                break;
            }
        }
        if (check) {
            System.out.println("You want to remove [ " + data.getPhoneNumber() + " ] (yes/no)?");
            char anwser = input.nextLine().charAt(0);
            if (anwser == 'y') {
                ManagerContacts.getManagerContactsList().remove(data);
                System.out.println("Remove Success!!");
            } else {
                displayMainMenu();
            }
        } else {
            System.err.println("Not Find Phone number");
        }
    }

    public void searchContacts() {
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        List<ManagerContacts> contactsList = new ArrayList<>();
        for (ManagerContacts contacts : ManagerContacts.getManagerContactsList()) {
            if (contacts.getName().contains(name)) {
                contactsList.add(contacts);
            }
        }
        if (!contactsList.isEmpty()) {
            System.out.println("_______Contacts list have [ " + name + " ]___________");
            for (ManagerContacts contacts : contactsList) {
                System.out.printf("%-25s%-15s%-15s%-15s%-20s%-25s", contacts.getName(), contacts.getGender(), contacts.getPhoneNumber(),
                        contacts.getGroup(), contacts.getAddress(), contacts.getEmail());
                System.out.println();
            }
        } else {
            System.err.println("Not Find Phone number");
        }
    }
}
