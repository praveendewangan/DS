package practice.searchingAndSorting;

import java.util.Arrays;

public class _27WeightedJobScheduling {
    // O(nlogn),O(n)
    public static class Job { 
        int start,finish,profit;
        Job(int start,int finish,int profit) {
            this.start = start;
            this.finish = finish;
            this.profit = profit;
        }
    }
    public static void main(String[] args) {
        Job jobs[] = {new Job(1, 2, 50), new Job(3, 5, 20), 
            new Job(6, 19, 100), new Job(2, 100, 200)}; 
        System.out.println(schedule(jobs));
    }

    private static int schedule(Job[] jobs) {
        int n = jobs.length;
        Arrays.sort(jobs,(a,b) -> {
            if(a.finish < b.finish){
                return -1;
            } else if(a.finish > b.finish) {
                return 1;
            } else {
                return 0;
            }
        });
        int[] tables = new int[n];
        tables[0] = jobs[0].profit;
        for(int i = 1; i < n; i++) {
            int maxProfit = jobs[i].profit;
            int l = binarySearch(jobs,i);
            if(l != -1){
                maxProfit += tables[l];
            }
            tables[i] = Math.max(maxProfit, tables[i-1]);
        }
        return tables[n-1];
    } 
    private static int binarySearch(Job[] jobs,int idx) {
        int lo=0,hi=idx-1;
        while(lo <= hi) {
            int mid = (lo+hi)/2;
            if(jobs[mid].finish <= jobs[idx].start){
                if(jobs[mid+1].finish <= jobs[idx].start) {
                    lo = mid + 1;
                } else {
                    return mid;
                }
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }
}
