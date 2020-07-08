package abstract_class_interface.practice;

import java.util.Arrays;

public class CircleComparatorTest {
    public static void main(String[] args) {
        Circle[] circles = new Circle[5];
        circles[0] = new Circle(3.6);
        circles[1] = new Circle(4.2);
        circles[2] = new Circle();
        circles[3] = new Circle(3.5, "red", false);
        circles[4] = new Circle(3.8, "blue", true);
        System.out.println("Pre-sorted:");
        for (Circle circle : circles) {
            System.out.println(circle);
        }

        Compara circleComparator = new CircleComparator();
        Arrays.sort(circles, circleComparator);

        System.out.println("After-sorted:");
        for (Circle circle : circles) {
            System.out.println(circle);
        }
    }
}
