package array_method.bai_tap;

import java.util.Scanner;

public class Tongphantuduongcheohinhvuong {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int size;
        System.out.print("Nhập chiều dài Ma trận:  ");
        size = myScanner.nextInt();
        int[][] arr = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("Nhập phần tử thứ [row " + (i + 1) + "][column " + (j + 1) + "]: ");
                arr[i][j] = myScanner.nextInt();
            }
        }
        System.out.println("Ma trận:");
        for (int[] element : arr) {
            for (int x : element) {
                System.out.print(x + "  ");
            }
            System.out.println("");
        }

        int sum = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    sum += arr[i][j];
                }
            }
        }
        System.out.println("Tổng các phần tử ở đường chéo chính của ma trận là: " + sum);
    }
}
