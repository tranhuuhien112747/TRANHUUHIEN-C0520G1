package loop_in_java.thuc_hanh;

import java.util.Scanner;

public class Appmoney {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("nhap so tien gui?");
        double money = input.nextDouble();
        System.out.println("nhap so thang gui?");
        int month = input.nextInt();
        System.out.println("nhap lai suat?");
        double interset = input.nextDouble();
        double total_interset = 0;
            total_interset = money * (interset / 100) / 12 * month;
        System.out.println("LAI SUAT LA :" + total_interset);
    }
}
