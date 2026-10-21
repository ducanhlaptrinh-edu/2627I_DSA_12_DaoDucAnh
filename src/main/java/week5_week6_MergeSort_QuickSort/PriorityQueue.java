package week5_week6_MergeSort_QuickSort;

import java.util.NoSuchElementException;

public class PriorityQueue {
    private final int[] arr;
    private int N ;
    public PriorityQueue(int capacity) {
        this.arr = new int[capacity];
        this.N = 0;
    }
    public int size() {return N;}
    public boolean isEmpty(){return N==0;}
    public void insert(int x){
        arr[N++] = x;
    }
    public int delMin(){
        if(isEmpty()){throw new NoSuchElementException("Priority Queue is Empty");}
        int minI = 0;
        for(int i = 1; i < N; i++){
            if(arr[i] < arr[minI]){
                minI = i;
            }
        }
        int minVal = arr[minI];
        exch(arr, minI, N-1);
        N--;
        return minVal;
    }
    private void exch(int[] arr, int i, int j){
        int swap = arr[i];
        arr[i] = arr[j];
        arr[j] = swap;
    }
}
