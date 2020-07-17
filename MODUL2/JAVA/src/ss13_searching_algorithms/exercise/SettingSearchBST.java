package ss13_searching_algorithms.exercise;

public class SettingSearchBST {
    public static int binarySearch(int array[], int low, int hight, int value) {

        int mid = (low + hight) / 2;
        if (hight >= low) {
            if (array[mid] == value) {
                return mid;
            } else if (array[mid] > value) {
                return binarySearch(array, low, mid - 1, value);
            } else {
                return binarySearch(array, mid + 1, hight, value);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arrList = {2, 7, 9, 10, 11, 15, 19, 23, 34, 35, 46, 48, 59, 86};
        System.out.println(binarySearch(arrList, 0, arrList.length - 1, 11));

    }
}
