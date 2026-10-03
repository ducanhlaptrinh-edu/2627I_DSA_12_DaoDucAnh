package week4_sorts;

public class Solution_U5 {
    static void insertIntoSorted(int[] arr){
        for(int i = 1; i < arr.length; i++){
            for(int j = i; j >= 1; j--){
                if(arr[i] < arr[j-1]){
                    arr[j] = arr[j-1];
                    printArray(arr);
                }else{
                    arr[j] = arr[i];
                    printArray(arr);
                    break;
                }
            }
        }

    }
    static void printArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
