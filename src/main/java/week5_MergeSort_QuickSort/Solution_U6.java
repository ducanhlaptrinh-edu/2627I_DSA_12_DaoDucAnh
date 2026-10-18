package week5_MergeSort_QuickSort;

public class Solution_U6 {
    public static void exch(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static int partition(int[] arr, int low, int high){
        int v = arr[high];
        int i = low;
        for(int j = low; j < high; j++){
            if(arr[j] <= v){
                exch(arr, i++, j);
            }
        }
        exch(arr, i, high);
        printArray(arr);
        return i;
    }
    public static void printArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
