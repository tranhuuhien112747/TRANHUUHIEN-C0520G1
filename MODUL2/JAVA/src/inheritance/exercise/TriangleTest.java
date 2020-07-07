package inheritance.exercise;

import java.util.Scanner;

public class TriangleTest {
    public static void main(String[] args) {
        Shape shape = new Shape();
        System.out.println(shape);
        Triangle triangle = new Triangle();
        System.out.println(triangle);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size 1:");
        double a = scanner.nextDouble();
        System.out.println("Enter size 2:");
        double b = scanner.nextDouble();
        System.out.println("Enter size 3:");
        double c = scanner.nextDouble();
        System.out.println("Enter height:");
        double h = scanner.nextDouble();
        System.out.println("Enter color:");
        scanner.nextLine();
        String color = scanner.nextLine();
        triangle = new Triangle(a, b, c, h);
        triangle.setColor(color);
        System.out.println(triangle);
    }
}
