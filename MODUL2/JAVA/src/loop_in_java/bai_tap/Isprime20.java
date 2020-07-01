package loop_in_java.thuc_hanh;

import java.util.Scanner;

public class Isprime20 {
    public static void main(String[] args) {
        int count = 0;
        int number = 2;
        Scanner input = new Scanner(System.in);
        System.out.println("You want to show how many primes?");
        int n = input.nextInt();
        while (count < n) {
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
    }
}

