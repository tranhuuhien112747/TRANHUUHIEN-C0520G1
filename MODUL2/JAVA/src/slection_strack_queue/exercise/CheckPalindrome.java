package slection_strack_queue.exercise;

import java.util.*;

/**
 * [Optional] [Bài tập] Kiểm tra chuỗi Palindrome sử dụng Queue.
 */
public class CheckPalindrome {
    public static boolean isPalindrome(String str) {
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();
        boolean checkPalindrome = false;
        for (int i = 0; i < str.length(); i++) {
            queue.add(str.charAt(i));
            stack.push(str.charAt(i));
        }
        while (!stack.isEmpty()) {
            //so sanh 2 chuoi
            if (stack.pop().equals(queue.poll())) {
                checkPalindrome = true;
            } else {
                checkPalindrome = false;
                break;
            }
        }
        return checkPalindrome;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your string: ");
        String str = input.nextLine();

        boolean isPalindrome = isPalindrome(str);

        if (isPalindrome) {
            System.out.println("This is palindrome");
        } else {
            System.out.println("This is not palindrome");
        }
    }
}
