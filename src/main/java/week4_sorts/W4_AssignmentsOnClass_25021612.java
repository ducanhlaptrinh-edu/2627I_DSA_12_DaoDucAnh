package week4_sorts;

public class W4_AssignmentsOnClass_25021612 {
    static void SelectionSort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            int min = i;
            for(int j = i; j < arr.length; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
    static int find_H_Index(int[] arr, int l) {
        SelectionSort(arr);
        for (int i = l; i >= 1; i--) {
            if (arr[l - i] >= l) return i;
        }
        return 0;
    }
}
