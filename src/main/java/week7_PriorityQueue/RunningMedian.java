package week7_PriorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class RunningMedian {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        PriorityQueue<Integer> minQueue = new PriorityQueue<>(); // contain the halves larger
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder()); // contain the halves smaller
        for (int i = 0; i < N; i++) {
            int number = input.nextInt();
            maxQueue.add(number);
            minQueue.add(maxQueue.poll()); // ensure any elements in the minQueue >= maxQueue
            if (maxQueue.size() < minQueue.size()) {
                maxQueue.add(minQueue.poll());
            }
            double median = 0;
            if (maxQueue.size() > minQueue.size()) {
                median = (double) maxQueue.peek();
            } else if (maxQueue.size() == minQueue.size()) {
                median = (maxQueue.peek() + minQueue.peek()) / 2;
            }
            System.out.printf("%.1f\n", median);
        }
        input.close();
    }

}
