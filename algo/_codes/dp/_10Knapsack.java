
import java.io.*;
import java.util.*;

public class _10Knapsack {
    private static int max = 0;
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
        
        // System.out.println(knapsackrec(values,wts,0,n,cap,0));
        // max = 0;
        // knapsackrecGlobal(values,wts,0,n,cap,0);
        // System.out.println(max);
        // System.out.println(knapsackRec2(values,wts,n-1,cap));
        // System.out.println(knapsackMemo(values,wts,n-1,cap,new int[n+1][cap+1]));
        System.out.println(knapsackTab(values,wts,cap));
    }
    // Using recursion
    private static void knapsackrecGlobal(int[] values,int[] wts,int idx,int n,int cap,int total){
        if(cap == 0){
            max = Math.max(max,total);
            return;
        }
        if(idx == n) {
            max = Math.max(max,total);
            return;
        }
        if(cap - wts[idx] >= 0){
            knapsackrecGlobal(values,wts,idx+1,n,cap-wts[idx],total+values[idx]);
        }
        knapsackrecGlobal(values,wts,idx+1,n,cap,total);
    }
    
    private static int knapsackrec(int[] values,int[] wts,int idx,int n,int cap,int total){
        if(idx == n) {
            if(cap == 0){
                return total;
            }
            return 0;
        }
        int sum = 0;
        if(cap - wts[idx] >= 0){
            sum = Math.max(sum,knapsackrec(values,wts,idx+1,n,cap-wts[idx],total+values[idx]));
        }
    
        sum = Math.max(sum,knapsackrec(values,wts,idx+1,n,cap,total));
        return sum;
    }

    private static int knapsackRec2(int[] values,int[] wts,int idx,int cap) {
        if(idx == -1) {
            return 0;
        }

        int v1 = 0;

        if(cap - wts[idx] >= 0) {
            v1 = knapsackRec2(values,wts,idx-1,cap-wts[idx]) + values[idx];
        }
        
        int v2 = knapsackRec2(values,wts,idx-1,cap);
        return Math.max(v1, v2);
    }

    // Using memorisation
    private static int knapsackMemo(int[] values,int[] wts,int idx,int cap,int[][] dp) {
        if(idx == -1) {
            return dp[idx+1][cap] = 0;
        }
        if(dp[idx+1][cap] != 0){
            return dp[idx+1][cap];
        }
        int v1 = 0;

        if(cap - wts[idx] >= 0) {
            v1 = knapsackMemo(values,wts,idx-1,cap-wts[idx],dp) + values[idx];
        }
        
        int v2 = knapsackMemo(values,wts,idx-1,cap,dp);
        return dp[idx+1][cap] = Math.max(v1, v2);
    }

    // Using tabulation
    private static int knapsackTab(int[] values,int[] wts,int capacity) {
        int[][] dp = new int[wts.length+1][capacity+1];
        for(int i = 1; i <= values.length; i++) {
            for(int cap = 1; cap <= capacity; cap++) {
                if(cap < wts[i-1]) {
                    dp[i][cap] = dp[i-1][cap];
                } else {
                    // yes call
                    int v1 = dp[i-1][cap-wts[i-1]] + values[i-1];
                    // no call
                    int v2 = dp[i-1][cap];

                    dp[i][cap] = Math.max(v1, v2);
                }
            }
        }
        return dp[wts.length][capacity];
    }
}
