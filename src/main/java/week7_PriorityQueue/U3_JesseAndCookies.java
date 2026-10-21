package week7_PriorityQueue;

import java.util.PriorityQueue;
import java.util.Scanner;

public class U3_JesseAndCookies {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N =  input.nextInt();
        int K = input.nextInt();
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        for(int i = 0; i < N; i++){
            minPQ.add(input.nextInt());
        }
        int count = 0;
        while(minPQ.size() > 1 && minPQ.peek() < K){
            int m1 =  minPQ.poll();
            int m2 = minPQ.poll();
            int new_m = m1 + 2 * m2;
            minPQ.add(new_m);
            count++;
        }
        if(minPQ.peek() < K){
            System.out.println(1);
        }else{
            System.out.println(count);
        }
        input.close();
    }
}
