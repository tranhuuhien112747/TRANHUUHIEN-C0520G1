package introduction_to_java.thuc_hanh;


import java.util.Scanner;

public class App_hello {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập tên?");
        String value = input.nextLine();
        System.out.println("HELLO " + value);
    }
}
