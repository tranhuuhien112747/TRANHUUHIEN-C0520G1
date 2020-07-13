package slection_strack_queue.exercise;

import java.util.Scanner;
import java.util.Stack;

/**
 * [Optional] [Bài tập] Kiểm tra dấu ngoặc trong biểu thức sử dụng Stack.
 */
public class CheckBracket {
    public static boolean checkSym(String string) {
        Stack<Character> stack = new Stack<>();
        boolean checkBracket = false;
        char left = '(';
        char right = ')';
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if (left == string.charAt(i)) {
                stack.push(left);
                count++;
            }
            if (right == string.charAt(i)) {
                count--;
                if (!stack.isEmpty()) {
                    checkBracket = true;
                    stack.pop();
                } else {
                    checkBracket = false;
                }
            }
            //System.out.println(count);
        }
        if (count != 0) {
            checkBracket = false;
        }
        return checkBracket;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter string:");
        String str = scanner.nextLine();
        boolean check = checkSym(str);
        if (check) {
            System.out.println("Well");
        } else {
            System.out.println("???????????");
        }
    }
}
