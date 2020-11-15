package hashmapandheap;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class _5KLargestElemetsInArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        Queue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < a.length; i++) {
            if(i < k) {
                pq.add(a[i]);
            } else {
                if(a[i] > pq.peek()) {
                    pq.remove();
                    pq.add(a[i]);
                }
            }
        }
        while (pq.size()> 0) {
            System.out.println(pq.remove());
        }
    }
}
