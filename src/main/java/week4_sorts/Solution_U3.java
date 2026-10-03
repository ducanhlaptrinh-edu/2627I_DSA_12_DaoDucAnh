package week4_sorts;

import java.util.Scanner;

public class Solution_U3 {
    static void insertIntoSorted(int[] arr){
        int target = arr[arr.length-1];
        for(int j = arr.length-1; j >= 1; j--){
            if(target < arr[j-1]){
                arr[j] = arr[j-1];
                printArray(arr);
            }else{
                arr[j] = target;
                printArray(arr);
                break;
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
