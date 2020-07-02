package array_method.bai_tap;

import java.util.Scanner;

public class Timminarray {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Nhập độ dài mảng: ");
            size = scanner.nextInt();
            if (size > 10)
                System.out.println("độ dài ngắn hơn 10");
        } while (size > 10);
        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.print("Enter element " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
            i++;
        }
        System.out.println("Mảng có:");
        for (i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        int min = array[0];
        int index = 0;
        for (int j = 0; j < array.length; j++) {
            if (min > array[j]) {
                min = array[j];
                index = j;
            }
        }
        System.out.println("\n" + "Min value is " + "'" + min + "'" + " at the " + index);

    }
}
