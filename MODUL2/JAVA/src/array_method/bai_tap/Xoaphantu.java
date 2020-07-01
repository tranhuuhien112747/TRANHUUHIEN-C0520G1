package array_method.bai_tap;

import java.util.Scanner;

public class Xoaphantu {
    public static void main(String[] args) {
        int index = -1;
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Nhập độ dài mãng: ");
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
        System.out.println("Mang ban đầu:");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }
        System.out.println("\n" + "Nhập phần tử muốn xóa");
        int x = scanner.nextInt();
        System.out.println("\n" + "Mảng sau khi xóa phần tử " + x + " là:");
        for (int j = 0; j < array.length; j++) {
            if (array[j] == x) {
                index = j;
            }
        }
        for (int j = index; j < array.length - 1; j++) {
            array[j] = array[j + 1];
        }
        array[array.length - 1] = 0;
        for (int element : array) {
            System.out.print(element + "\t");
        }
    }
}
