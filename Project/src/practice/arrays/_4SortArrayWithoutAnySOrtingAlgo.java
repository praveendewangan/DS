package practice.arrays;

import java.util.PriorityQueue;
import java.util.Queue;

public class _4SortArrayWithoutAnySOrtingAlgo {
    public static void main(String[] args) {
        int[] a = {0 ,2, 1, 2, 0};
        // Queue<Integer> pq = new PriorityQueue<>();
        // for (int i = 0; i < a.length; i++) {
        //     pq.add(a[i]);
        // }
        // while (pq.size() != 0) {
        //     System.out.println(pq.poll());
        // }

        int l = 0;
        int m = 0;
        int h = a.length - 1;
        while(m <= h) {
            if(a[m] == 0) {
                swap(a,m,l);
                m++;
                l++;
            } else if(a[m] == 1) {
                m++;
            } else {
                swap(a,m,h);
                h--;
            }
        }
    }
    private static void swap(int[] a,int i,int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
