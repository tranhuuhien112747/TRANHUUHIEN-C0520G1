package ss13_searching_algorithms.exercise;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * [Optional] [Bài tập] Tìm chuỗi liên tiếp có độ dài lớn nhất.
 */
public class FindStringMax {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList<Character> max = new LinkedList<>();
        LinkedList<Character> list = new LinkedList<>();
        System.out.println("Enter a string: ");
        String string = input.nextLine();

        for (int i = 0; i < string.length(); i++) {
            if (list.size() > 1 && string.charAt(i) <= list.getLast() && list.contains(string.charAt(i))) {
                list.clear();
            }
            list.add(string.charAt(i));
            if (list.size() > max.size()) {
                max.clear();
                max.addAll(list);
            }
        }
        for (Character element : max) {
            System.out.print(element);
        }
        System.out.println();

    }
}
