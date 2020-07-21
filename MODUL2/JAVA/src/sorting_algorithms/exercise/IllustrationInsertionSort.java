package sorting_algorithms.exercise;

import java.util.Arrays;

/**
 * [Bài tập] Minh hoạ thuật toán sắp xếp chèn.
 */
public class IllustrationInsertionSort {
    public static void insertionSort(double[] list) {
        double currentElement;
        int count = 1;
        for (int i = 1; i < list.length; i++) {
            System.out.println("Step" + count);
            System.out.println("Current Element = " + list[i]);
            currentElement = list[i];
            int k;
            for (k = i - 1; k >= 0 && list[k] > currentElement; k--) {
                System.out.println("Compare " + list[k] + " with " + currentElement);
                list[k + 1] = list[k];
            }
            System.out.println("K = "+k);
            list[k + 1] = currentElement;
            System.out.println("Array is inserted after compare: " + Arrays.toString(list));
            System.out.println();
            count++;
        }
    }

    public static void main(String[] args) {
        System.out.println("Array before sorting: ");
        double[] list = {1, 9, 4.5, 6.6, 5.7, -4.5, 3.4, 23.4, 13.1, 0};
        System.out.println(Arrays.toString(list));
        System.out.println("-----------------------------------------------");
        insertionSort(list);
        System.out.println("-----------------------------------------------");
        System.out.println("Array after sorting: ");
        System.out.println(Arrays.toString(list));
    }
}
