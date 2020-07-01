package introduction_to_java.thuc_hanh;

import java.util.Scanner;

public class Chanemoney {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("nhập số USD?");
        float a = input.nextFloat();
        float vnd = a * 23000;
        System.out.println(a + " USD = " + vnd + " vnđ");
    }
}
