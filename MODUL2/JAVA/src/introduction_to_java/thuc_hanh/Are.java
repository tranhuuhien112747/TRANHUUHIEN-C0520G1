package introduction_to_java.thuc_hanh;

import java.util.Scanner;

public class Are {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("nhập chiều dài: ");
        int number1 = input.nextInt();
        System.out.print("nhập chiều rộng: ");
        int number2 = input.nextInt();
        int are = number1 * number2;
        System.out.println("DIỆN tích là: " + "\n"+ are);

    }
}
