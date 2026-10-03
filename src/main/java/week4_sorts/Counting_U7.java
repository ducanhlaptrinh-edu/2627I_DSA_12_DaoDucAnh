package week4_sorts;

public class Counting_U7 {
    static void counting(int[] arr){
        Integer[] count = new Integer[100];
        for(int a : arr){
            count[a]++;
        }
        printCountArray(count);
    }
    static void printCountArray(Integer[] count){
        for(int a : count){
            System.out.print(a+" ");
        }
    }
}
