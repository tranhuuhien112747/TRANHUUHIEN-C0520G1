package sorting_algorithms.practice;

public class InsertionSort {
    static double[] list = {1, 9, 4.5, 6.6, 5.7, -4.5};

    public static void insertionSort(double[] list) {
        double currentElement;
        int k;
        for (int i = 1; i < list.length; i++) {
            currentElement = list[i];
            for (k = i - 1; k >= 0 && list[k] > currentElement; k--) {
                list[k + 1] = list[k];
            }
            list[k + 1] = currentElement;
        }
    }

    public static void main(String[] args) {
        insertionSort(list);
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
    }
}
