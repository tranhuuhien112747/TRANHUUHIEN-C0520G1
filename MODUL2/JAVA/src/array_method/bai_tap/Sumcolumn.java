package array_method.bai_tap;
import java.util.Scanner;
public class Sumcolumn {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int row, col;
        System.out.print("Nhập độ dài mảng 2D: ");
        row = myScanner.nextInt();
        System.out.print("Nhập độ dài cột: ");
        col = myScanner.nextInt();
        int[][] arr = new int[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
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
        System.out.print("Nhập cột cần tính tổng: ");
        int index = myScanner.nextInt();
        int sum = 0;
        for(int i = 0; i < row; i++){
            sum += arr[i][index-1];
        }
        System.out.println("Tổng của cột " + index + " là:  " + sum);
    }
}
