package practice.greedy;

import java.util.Arrays;

public class _2JobSequencingProblem {
    // O(nlogn),O(n)
    static class Job {
        int id;
        int deadline;
        int profit;
    }
    int[] JobScheduling(Job arr[], int n){
        Arrays.sort(arr,(a,b) -> (b.profit-a.profit));
        int maxi = 0;
        for(int i=0;i<n;i++){
            if(arr[i].deadline > maxi) {
                maxi = arr[i].deadline;
            }
        }
        
        int result[] = new int[maxi+1];
        for(int i=1;i<=maxi;i++) {
            result[i] = -1;
        }
        int countJob = 0;
        int jobprofit = 0;
        
        for(int i=0;i < n;i++) {
            for(int j=arr[i].deadline;j > 0;j--) {
                if(result[j] == -1) {
                    result[j] = i;
                    countJob++;
                    jobprofit += arr[i].profit;
                    break;
                }
            }
        }
        int[] ans = new int[2];
        ans[0] = countJob;
        ans[1] = jobprofit;
        return ans;
    }
}
