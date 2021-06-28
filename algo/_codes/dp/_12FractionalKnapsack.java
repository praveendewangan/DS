import java.io.*;
import java.util.*;

public class _12FractionalKnapsack {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] values = new int[n];
        int[] wts = new int[n];
        for(int i = 0; i < n; i++){
            values[i] = scn.nextInt();
        }
        for(int i = 0; i < n; i++){
            wts[i] = scn.nextInt();
        }
        int cap = scn.nextInt();
        System.out.println(fractionalKs(values,wts,n-1,cap));
        
    }
    static class Pair implements Comparable<Pair>{
        int val;
        int wt;
        double frac;
        Pair(int val,int wt) {
            this.val = val;
            this.wt = wt;
            this.frac = val * 1.0 / wt;
        }
        
        public int compareTo(Pair o) {
            if(this.frac > o.frac) {
                return 1;
            } else if(this.frac < o.frac) {
                return -1;
            } else {
                return 0;
            }
        }
    }
    private static double fractionalKs(int[] values,int[] wts,int idx,int cap) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < wts.length; i++) {
            pq.add(new Pair(values[i],wts[i]));
        }
        
        double profit = 0;
        
        while(pq.size() > 0) {
            Pair rm = pq.remove();
            
            if(cap >= rm.wt) {
                profit += rm.val;
                cap -= rm.wt;
            } else {
                profit += rm.frac*cap;
                cap = 0;
            }
        }
        return profit;
    }
}





