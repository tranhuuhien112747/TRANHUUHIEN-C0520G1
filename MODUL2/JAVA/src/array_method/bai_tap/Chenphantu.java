package array_method.bai_tap;

import java.util.Scanner;

public class Chenphantu {
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
        System.out.println("Mảng ban đầu:");
        for (i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println("\n" + "Nhập phần tử muốn chèn");
        int x = scanner.nextInt();
        System.out.println("\n" + "Nhập vị trí muốn chèn");
        int index = scanner.nextInt();
        System.out.println("Mảng sau khi thêm vào:");
        for (i = array.length; i < index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = x;
        for (int element : array) {
            System.out.print(element + " ");
        }
    }
}
