package slection_strack_queue.exercise;

import java.util.Scanner;
import java.util.TreeMap;

/**
 * [Bài tập] Đếm số lần xuất hiện của mỗi từ trong một chuỗi sử dụng Map.
 */
public class CharactersTreeMap {
    public static void main(String[] args) {
        TreeMap<Character, Integer> treeMap = new TreeMap<Character, Integer>();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter String: ");
        String data = input.nextLine().toLowerCase();
        for (int i = 0; i < data.length(); i++) {
            char temp = data.charAt(i);
            Integer count = treeMap.get(temp);
            if (count == null) {
                treeMap.put(temp, 1);
            } else {
                count++;
                treeMap.put(temp, count);
            }
        }
        System.out.println(treeMap);
    }
}
