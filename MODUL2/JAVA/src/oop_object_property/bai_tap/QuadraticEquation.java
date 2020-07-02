package oop_object_property.bai_tap;

import java.util.Scanner;

public class QuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a:");
        double a = scanner.nextDouble();
        System.out.print("Enter b:");
        double b = scanner.nextDouble();
        System.out.print("Enter c:");
        double c = scanner.nextDouble();
        Equation2 equation2 = new Equation2(a, b, c);
        if (equation2.getDiscriminant() < 0) {
            System.out.print("PT vô nghiệm");
        } else if (equation2.getDiscriminant() == 0) {
            System.out.print("PT có nghiệm :" + (-equation2.getNumber2() / 2 * equation2.getNumber1()));
        } else if (equation2.getDiscriminant() > 0) {
            System.out.print("PT có nghiệm x1= :" + equation2.getRoot1());
            System.out.print("và x2=" + equation2.getRoot2());
        }
    }
}

class Equation2 {

    private double number3;
    private double number2;
    private double number1;

    public Equation2(double a, double b, double c) {
        this.number1 = a;
        this.number2 = b;
        this.number3 = c;

    }

    public double getNumber1() {
        return number1;
    }

    public double getNumber2() {
        return number2;
    }

    public double getNumber3() {
        return number3;
    }

    public double getDiscriminant() {
        double delta;
        return delta = this.getNumber2() * this.getNumber2() - 4 * this.getNumber1() * this.getNumber3();
    }

    public double getRoot1() {
        double r1;
        return r1 = (-this.getNumber2() + Math.sqrt(this.getDiscriminant())) / 2 * this.getNumber1();
    }

    public double getRoot2() {
        double r2;
        return r2 = (-this.getNumber2() - Math.sqrt(this.getDiscriminant())) / 2 * this.getNumber1();
    }

}