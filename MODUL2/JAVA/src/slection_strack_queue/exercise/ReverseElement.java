package slection_strack_queue.exercise;

import java.util.Scanner;
import java.util.Stack;

/**
 * [Bài tập] Đảo ngược phần tử trong mảng số nguyên sử dụng Stack.
 */
public class ReverseElement {
    public static void main(String[] args) {
        System.out.println("-------------------REVERSE ELEMENT CHARACTER----------------------");
        Scanner scanner = new Scanner(System.in);
        Stack<Character> charStack = new Stack<>();
        System.out.print("Enter string: ");
        String data = scanner.nextLine();
        for (int i = 0; i < data.length(); i++) {
            charStack.push(data.charAt(i));
        }

        System.out.println();
        System.out.println("Before-reverse: ");
        System.out.println(data);
        String string = "";
        int len = charStack.size();
        for (int i = 0; i < len; i++) {
            string += charStack.pop();
        }
        System.out.println();
        System.out.println("After-reverse: ");
        System.out.print(string);

        //---------------------------REVERSE ELEMENT INTERGER------------------------
        System.out.println();
        System.out.println("-------------------REVERSE ELEMENT INTEGER----------------------");
        Stack<Integer> intStack = new Stack<Integer>();
        Scanner input = new Scanner(System.in);
        int[] array = new int[5];
        int i = 0;
        while (i < 5) {
            System.out.print("Enter element " + (i + 1) + ": ");
            array[i] = input.nextInt();
            i++;
        }
        System.out.println("Before-reverse: ");
        for (int element : array) {
            System.out.print(element + "\t");
        }
        for (int j = 0; j < array.length; j++) {
            intStack.push(array[j]);
        }

        for (int j = 0; j < array.length; j++) {
            array[j] = intStack.pop();
        }
        System.out.println();
        System.out.println("After-reverse: ");
        for (int num : array) {
            System.out.print(num + "\t");
        }
    }
}
