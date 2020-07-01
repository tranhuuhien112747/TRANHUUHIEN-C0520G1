package introduction_to_java.thuc_hanh;

import java.util.Scanner;

public class Day_in_month {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập tháng cần kiểm tra?");
        int number = input.nextInt();
        switch (number) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("Tháng " + number + " có 31 ngày");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("Tháng " + number + " có 30 ngày");
                break;
            case 2:
                System.out.println("Tháng " + number + " có 29 hoặc 28 ngày  ");
                break;
            default:
                System.out.println("không hợp lệ");
        }
    }

}
