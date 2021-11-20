import java.util.*;
import java.io.*;

public class _6FIndKClosestElementsLC658 {

    /*find 'k' closest element to 'x' and return answer list*/
    /*elements in answer list should be in ascending order*/
    static class Pair implements Comparable<Pair>{
        int val;
        int gap;
        Pair(int val,int gap) {
            this.val = val;
            this.gap = gap;
        }
        
        public int compareTo(Pair p) {
            if(this.gap == p.gap) {
                return this.val - p.val;
            } else {
                return this.gap - p.gap;
            }
        }
    }
    public static ArrayList<Integer> findClosest(int[]arr,int k,int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int val : arr){
            if(pq.size() < k) {
                pq.add(new Pair(val,Math.abs(val-x)));
            } else {
                int gap = Math.abs(val-x);
                if(pq.peek().gap > gap){
                    pq.remove();
                    pq.add(new Pair(val,Math.abs(val-x)));
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        while(pq.size() > 0) {
            Pair rm = pq.remove();
            list.add(rm.val);
        }
        Collections.sort(list);
        return list;
    }

    public static void main(String[]args) {

        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]arr = new int[n];

        for(int i=0; i < n;i++) {
            arr[i] = scn.nextInt();
        }

        int k = scn.nextInt();
        int x = scn.nextInt();

        ArrayList<Integer>ans = findClosest(arr,k,x);

        for(int val : ans) {
            System.out.print(val + " ");
        }

    }
}