package introduction_to_java.thuc_hanh;

import java.util.Scanner;

public class Body_bmi {
    public static void main(String[] args) {
        double a;
        double b;
        double bmi;
        Scanner input = new Scanner(System.in);
        System.out.println("NHẬP CÂN NẶNG?");
        a = input.nextDouble();
        System.out.println("NHẬP CHIỀU CAO?");
        b = input.nextDouble();
        bmi = a / (b * b);
        if (bmi >= 30.0) {
            System.out.println("Obese");
        } else if (bmi >= 25.0) {
            System.out.println("OverWeight");
        } else if (bmi >= 18.0) {
            System.out.println("Normal");
        } else {
            System.out.println("Undelweight");
        }
    }
}
