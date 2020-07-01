package array_method.bai_tap;

import java.util.Scanner;

public class Gopmang {
    public static void main(String[] args) {
        int size;
        int[] array;
        int[] array2;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Nhập độ dài mảng: ");
            size = scanner.nextInt();
            if (size > 10)
                System.out.println("độ dài ngắn hơn 10");
        } while (size > 10);
        array = new int[size];
        array2 = new int[size];
        int i = 0;
        int j = 0;
        System.out.println("Nhập phần tử mảng 1:");
        while (i < array.length) {
            System.out.print("Enter element  " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
            i++;
        }
        System.out.println("Nhập phần tử mảng 2:");
        while (j < array2.length) {
            System.out.print("Enter element " + (j + 1) + ": ");
            array2[j] = scanner.nextInt();
            j++;
        }
        System.out.println("Mảng 1:");
        for (i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println("\n" + "Mảng 2:");
        for (j = 0; j < array2.length; j++) {
            System.out.print(array2[j] + "\t");
        }
        int[] array3 = new int[array.length + array2.length];
        System.out.println("\n" + "Mảng 3 sau khi gộp:");
        for (i = 0; i < array.length; i++) {
            array3[i] = array[i];
        }
        int count=0;
        for (i = array.length ; i < array3.length; i++) {
            array3[i] = array2[count];
            count++;
        }
        for (int element : array3) {
            System.out.print(element + "\t");
        }
    }
}
