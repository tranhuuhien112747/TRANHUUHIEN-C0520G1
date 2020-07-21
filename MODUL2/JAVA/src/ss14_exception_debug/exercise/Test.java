package ss14_exception_debug.exercise;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {
    public static void triangle(int a, int b, int c) throws IllegalTriangleException {
        int pc;
        if (a < 0 || b < 0 || c < 0) {
            throw new IllegalTriangleException("Triangle edge must be a non-negative number");
        } else if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalTriangleException("This is not a triangle");
        } else {
            pc = a + b + c;
        }
        System.out.println("The perimeter of the triangle is : " + pc);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter a");
            int a = scanner.nextInt();
            System.out.println("Enter b");
            int b = scanner.nextInt();
            System.out.println("Enter c");
            int c = scanner.nextInt();
            System.out.println("Success");
            triangle(a, b, c);
        } catch (InputMismatchException i) {
            System.err.println("Enter incorrect format " + i);
        } catch (IllegalTriangleException e) {
            System.out.println(e);
        } finally {
            System.out.println("End");
        }
    }

}
