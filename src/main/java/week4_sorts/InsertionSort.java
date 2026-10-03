package week4_sorts;

public class InsertionSort {
    private int[] arr ;
    public InsertionSort(int[] arr) {
        this.arr = arr;
    }
    static void insertionSort(int[] arr) {
        for(int i = 1; i < arr.length; i++){
            for(int j = i; j >= 1; j++){
                if(arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }else{
                    break;
                }
            }
        }
    }
}
