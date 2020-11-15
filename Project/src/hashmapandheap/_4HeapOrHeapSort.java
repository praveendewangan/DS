package hashmapandheap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class _4HeapOrHeapSort {
    public static void main(String[] args) {
        Queue<Integer> pq = new PriorityQueue<>(); // High priority for small value
//        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // High priority for large value
        int[] a = {22,99,3,11,88,4,1};
        for (int n : a) {
            pq.add(n);
        }
        while (pq.size() > 0) {
            System.out.println(pq.peek());
            pq.remove();
        }
    }
}
