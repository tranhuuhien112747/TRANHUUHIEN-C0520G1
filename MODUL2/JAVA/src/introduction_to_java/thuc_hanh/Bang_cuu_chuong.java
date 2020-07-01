package introduction_to_java.thuc_hanh;

import java.util.Scanner;

public class Bang_cuu_chuong {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter	a	number:	");
        int number1 = input.nextInt();
        int number2 = input.nextInt();
        int expectedAnswer = input.nextInt();
        while (number1 + number2 != expectedAnswer) {
            System.out.print("Wrong	answer");
            expectedAnswer = input.nextInt();
        }
        System.out.println("You	got	it!");
    }
}