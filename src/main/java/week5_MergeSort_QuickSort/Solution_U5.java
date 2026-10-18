package week5_MergeSort_QuickSort;

import java.util.Collections;
import java.util.List;

public class Solution_U5 {
    public static List<Integer> quickSort(List<Integer> arr) {
        int lo = 0; int hi = arr.size() -1;
        int lt = lo; int gt = hi;
        int v = arr.get(lo);
        int i = lo;
        while(i<=gt){
            if(v < arr.get(i)){
                Collections.swap(arr, i, gt--);
            }else if(v > arr.get(i)){
                Collections.swap(arr, i++, lt++);
            }else i++;
        }
        return arr;
    }
    public static void printArray(List<Integer> arr){
        for(int i = 0; i < arr.size(); i++){
            System.out.print(arr.get(i)+" ");
        }
    }
}
