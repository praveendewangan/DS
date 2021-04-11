package practice.heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class _6MergeKSOrtedArrays {
    // O(nlogk),O(n)
    public static ArrayList<Integer> mergeKArrays(int[][] arrays,int k) 
    {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for(int[] a : arrays){
            for(int num : a){
                q.add(num);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        while(q.size() > 0) {
            list.add(q.remove());
        }
        return list;
    }
}
