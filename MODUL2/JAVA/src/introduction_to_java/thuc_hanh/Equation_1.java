package introduction_to_java.thuc_hanh;

import java.util.Scanner;

public class Equation_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập a:?");
        float number1 = input.nextFloat();
        System.out.print("Nhập b:?");
        float number2 = input.nextFloat();
        System.out.print("Phương trình có dạng là:" + "\n" + number1 + "X " + "+ " + number2 + " = 0 ");
        System.out.print("Phương trình có nghiệm là: ");
        float number3 = -number2 / number1;
        System.out.println(number3);
    }
}
