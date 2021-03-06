package array_method.bai_tap;

import java.util.Scanner;

public class Timmax2chieu {
    public static void main(String[] args) {
        int indexRow = -1, indexCol = -1;
        Scanner myScanner = new Scanner(System.in);
        int row, col;
        System.out.print("Nhập độ dài mảng 2D : ");
        row = myScanner.nextInt();
        System.out.print("Nhập độ dài cột: ");
        col = myScanner.nextInt();
        int[][] arr = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("Nhập phần tử thứ [row " + (i + 1) + "][column " + (j + 1) + "]: ");
                arr[i][j] = myScanner.nextInt();
            }
        }
        System.out.println("Mảng 2D : ");
        for (int i = 0; i < row; i++) {
            for (int element : arr[i]) {
                System.out.print(element + "  ");
            }
            System.out.println("");
        }
        int max = arr[0][0];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (max < arr[i][j]) {
                    max = arr[i][j];
                    indexRow = i;
                    indexCol = j;
                }
            }
        }
        System.out.print("Max là: " + max + " ở vị trí [row " + (indexRow + 1) + "][column " + (indexCol + 1 + "]"));
    }
}
