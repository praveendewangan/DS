import java.io.*;
import java.util.*;

public class _21FractionalKnapsack {
    
    private static class KnapHelper implements Comparable<KnapHelper> {
        int val;
        int wt;
        double val_by_wt;
        KnapHelper(int val, int wt) {
            this.val = val;
            this.wt = wt;
            this.val_by_wt = (val * 1.0) / wt;
        }
        public int compareTo(KnapHelper o) {
            if(this.val_by_wt > o.val_by_wt) {
                return 1;
            } else if(this.val_by_wt < o.val_by_wt) {
                return -1;
            } else {
                return 0;
            }
            // return Double.compare(this.val_by_wt, o.val_by_wt);
        }
    }

    private static double fractionalKnapsack(int[] val, int[] wts, int cap) {
        PriorityQueue<KnapHelper> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < val.length; i++) {
            pq.add(new KnapHelper(val[i], wts[i]));
        }
        double profit = 0;
        while(pq.size() > 0) {
            KnapHelper rem = pq.remove();
            if(rem.wt <= cap) {
                // consume all wt
                cap -= rem.wt;
                profit += rem.val;
            } else {
                // consume according to fraction, we have to exahuast capacity to 0
                profit += cap * rem.val_by_wt;
                cap = 0;
            }
            if(cap == 0) break;
        }
        return profit;
    }
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] val = new int[n];
        int[] wts = new int[n];
        for(int i=0; i < n; i++) {
            val[i] = scn.nextInt();
        }
        for(int i=0; i < n; i++) {
            wts[i] = scn.nextInt();
        }
        int cap = scn.nextInt();
        System.out.println(fractionalKnapsack(val,wts,cap));
    }
}