package practice.greedy;

import java.util.PriorityQueue;

public class _21MinCostOfRopes {
    // O(nlogn),O(n)
    long minCost(long arr[], int n) {
        PriorityQueue<Long> q = new PriorityQueue<>();
        
        for(long val : arr) {
            q.add(val);
        }
        long mincost = 0;
        while(q.size() > 1) {
            long temp = q.poll() + q.poll();
            mincost += temp;
            q.add(temp);
        }
        return mincost;
    }
}
