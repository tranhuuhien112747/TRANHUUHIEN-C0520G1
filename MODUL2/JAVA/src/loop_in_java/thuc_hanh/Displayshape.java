package loop_in_java.thuc_hanh;

import java.util.Scanner;

public class Displayshape {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            System.out.println("Menu");
            System.out.println("1. Print the rectangle");
            System.out.println("2. Print the square triangle");
            System.out.println("3. Print isosceles triangle");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 7; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.println("1. Top-left");
                    System.out.println("2. Top-right");
                    System.out.println("3. Botton-left");
                    System.out.println("4. Botton-right");
                    int select = input.nextInt();
                    switch (select) {
                        case 1:
                            for (int i = 1; i < 7; i++) {
                                for (int j = 1; j <= i; j++) {
                                    System.out.print("*");
                                }
                                System.out.println("  ");
                            }
                            break;
                        case 2:
                            for (int i = 7; i > 0; i--) {
                                for (int j = 1; j <= i; j++) {
                                    System.out.print("*");
                                }
                                System.out.println(" ");
                            }
                            break;
                        case 3:
                            for (int i = 1; i < 7; i++) {
                                for (int j = 1; j < 7; j++) {
                                    if (i + j >= 7) {
                                        System.out.print("*");
                                    } else {
                                        System.out.print(" ");
                                    }
                                }
                                System.out.println();
                            }
                            break;
                        case 4:
                            for (int i = 1; i < 7; i++) {
                                for (int j = 1; j < 7; j++) {
                                    if (i + j < 7) {
                                        System.out.print("*");
                                    } else {
                                        System.out.print(" ");
                                    }
                                }
                                System.out.println();
                            }
                            break;
                    }
                    break;
                case 3:
                    for (int i = 7; i >= 1; i--) {
                        for (int j = 1; j <= i; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;

            }
        }
    }
}
