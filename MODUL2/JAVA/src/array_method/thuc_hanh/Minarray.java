package array_method.thuc_hanh;

public class Minarray {
    public static int minValue(int[] array) {
        return -1;

    }

    public static void main(String[] args) {
        int[] arr = {4, 12, 7, 8, 1, 6, 9, 10, 11, 5};
        int index = minValue(arr);
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                index = i;
            }
        }
        System.out.println("Min value is " + min + " at the " + index);
    }
}
