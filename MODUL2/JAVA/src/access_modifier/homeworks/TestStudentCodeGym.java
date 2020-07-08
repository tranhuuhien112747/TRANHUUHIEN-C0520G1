package access_modifier.homeworks;

import java.util.Scanner;

public class TestStudentCodeGym {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StudentCodeGym student1 = new StudentCodeGym(1, "Tran A", "11/04/1996");
        StudentCodeGym student2 = new StudentCodeGym(2, "Nguyen B", "11/05/1997");
        StudentCodeGym student3 = new StudentCodeGym(3, "Le C", "13/06/1997");
        StudentCodeGym student4 = new StudentCodeGym(4, "Huynh D", "11/08/1995");
        StudentCodeGym student5 = new StudentCodeGym(5, "Ngo E", "22/04/1993");
        StudentCodeGym student6 = new StudentCodeGym(6, "Pham F", "23/09/1992");
        StudentCodeGymClass listStudent = new StudentCodeGymClass();
        listStudent.register(student1);
        listStudent.register(student2);
        listStudent.register(student3);
        listStudent.register(student4);
        listStudent.register(student5);
        listStudent.register(student6);
        listStudent.displayListStudent();
        boolean check;
        while (true) {
            System.out.println("Menu");
            System.out.println("1. Add New Student.");
            System.out.println("2. Delete Student.");
            System.out.println("3. Display All Student.");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    int addId;
                    do {
                        check = false;
                        System.out.print("Enter id: ");
                        addId = input.nextInt();
                        for (int i = 0; i < listStudent.getSize(); i++) {
                            if (listStudent.getIdStudent(i) == addId) {
                                System.out.println("ID already in the list. Please enter");
                                check = true;
                                break;
                            }
                        }
                    } while (check);
                    input.nextLine();
                    System.out.print("Enter name: ");
                    String addName = input.nextLine();
                    System.out.print("Enter date of birth: ");
                    String addDate = input.nextLine();
                    StudentCodeGym student = new StudentCodeGym(addId, addName, addDate);
                    listStudent.register(student);
                    break;
                case 2:
                    check = false;
                    System.out.println("Enter id you want to delete: ");
                    int delId = input.nextInt();
                    int index = 0;
                    for (int i = 0; i < listStudent.getSize(); i++) {
                        if (delId == listStudent.getIdStudent(i)) {
                            check = true;
                            index = i;
                        }
                    }
                    if (check) {
                        input.nextLine();
                        System.out.println("You to remove " + listStudent.getNameStudent(index) + " this student!!!");
                        listStudent.graduate(delId);
                    } else {
                        System.out.println("No exist this student.");
                    }
                    break;
                case 3:
                    listStudent.displayListStudent();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Invalid value!!!");
            }
        }
    }
}

