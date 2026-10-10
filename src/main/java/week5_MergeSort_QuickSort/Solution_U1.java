package week5_MergeSort_QuickSort;

public class Solution_U1 {
    public static int binarySearch(int[] arr, int low, int high, int key) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if(arr[mid] == key) return mid;
            else if(arr[mid] < key) low = mid + 1;
            else  high = mid - 1;
        }
        return -1;
    }
    public static int findIndex(int[] arr, int V){
        int low = 0;
        int high = arr.length - 1;
        return binarySearch(arr, low, high, V);
    }
}
