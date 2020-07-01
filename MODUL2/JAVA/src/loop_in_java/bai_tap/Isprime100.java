package loop_in_java.thuc_hanh;

import java.util.Scanner;

public class Isprime100 {
    public static void main(String[] args) {
        int number = 2;
        int count = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Primes number less than 100:");
        while (number < 100) {
            boolean check = true;
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    check = false;
                    break;
                }
            }
            if (check) {
                System.out.print(number + " ");
                count++;
            }
            number++;
        }
        System.out.println("Có tổng cộng " + count + " số nguyên tố nhỏ hơn 100");
    }
}
