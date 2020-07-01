package loop_in_java.thuc_hanh;

import java.util.Scanner;

public class Uclnnumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("TÌM UCLN CỦA 2 SỐ");
        System.out.println("Nhập số thứ 1:");
        int number1 = input.nextInt();
        System.out.println("nhập số thứ 2:");
        int number2 = input.nextInt();
        if (number1 == 0 && number2 == 0) {
            System.out.println("K có UCLN");
        } else if (number1 == 0) {
            System.out.println("UCLN = "+ Math.abs(number2));
        } else if (number2 == 0) {
            System.out.println("UCLN = " + Math.abs(number1) );
        } else {
            while (number1 != number2) {
                if (number1 > number2) {
                    number1 -= number2;
                } else {
                    number2 -= number1;
                }
            }
            System.out.println("ucln= " + number1);
        }
    }
}
