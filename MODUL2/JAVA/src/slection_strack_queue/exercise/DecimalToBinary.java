package slection_strack_queue.exercise;

import java.util.Scanner;
import java.util.Stack;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        System.out.print("Enter decimal number: ");
        int number = input.nextInt();
        String result = "";
        if (number == 0) {
            result="0";
        } else {
            while (number != 0) {
                int numberMod2 = number % 2;
                number = number / 2;
                stack.push(numberMod2);
            }
        }
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            result += stack.pop();
        }
        System.out.println(result);
    }
}
