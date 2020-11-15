package practice.arrays;

import java.util.PriorityQueue;
import java.util.Queue;

public class _4SortArrayWithoutAnySOrtingAlgo {
    public static void main(String[] args) {
        int[] a = {0 ,2, 1, 2, 0};
        Queue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < a.length; i++) {
            pq.add(a[i]);
        }
        while (pq.size() != 0) {
            System.out.println(pq.poll());
        }
    }
}
