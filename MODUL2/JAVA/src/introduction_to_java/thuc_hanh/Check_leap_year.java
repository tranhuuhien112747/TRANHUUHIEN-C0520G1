package introduction_to_java.thuc_hanh;

import java.util.Scanner;

public class Check_leap_year {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("NHẬP NĂM MUỐN KIỂM TRA:?");
        int number = input.nextInt();
        boolean leapyear = false;
        boolean leapyear4 = number % 4 == 0;
        boolean leapyer100 = number % 100 == 0;
        boolean leapyear400 = number % 400 == 0;
        if (leapyear4) {
            if (leapyer100) {
                if (leapyear400) {
                    leapyear = true;
                }
            } else {
                leapyear = true;
            }
        }
        if (leapyear) {
            System.out.println("Năm " + number + " là năm nhuận");
        } else {
            System.out.println("Năm " + number + " không phải năm nhuận");
        }
    }
}
