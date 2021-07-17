import java.io.*;
import java.util.*;

public class _11UnbondedKnapsack {

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
        // System.out.println(unboundKS(values,wts,n-1,cap));
        // System.out.println(unboundKSMemo(values,wts,n-1,cap,new int[n+1][cap+1]));
        System.out.println(unboundKSTab(values,wts,cap));
    }
    // using Recursion
    private static int unboundKS(int[] values,int[] wts,int idx,int cap) {
        if(cap == 0 || idx == -1) {
            return 0;
        }

        int v1 = 0;

        if(cap - wts[idx] >= 0) {
            v1 = unboundKS(values,wts,idx,cap-wts[idx]) + values[idx];
        }
        
        int v2 = unboundKS(values,wts,idx-1,cap);
        return Math.max(v1, v2);
    }
    
    // Using memorisation
    private static int unboundKSMemo(int[] values,int[] wts,int idx,int cap,int[][] dp) {
        if(cap == 0 || idx == -1) {
            return dp[idx+1][cap]=0;
        }
        if(dp[idx+1][cap] != 0) {
            return dp[idx+1][cap];
        }

        int v1 = 0;
        if(cap - wts[idx] >= 0) {
            v1 = unboundKSMemo(values,wts,idx,cap-wts[idx],dp) + values[idx];
        }
        
        int v2 = unboundKSMemo(values,wts,idx-1,cap,dp);
        return dp[idx+1][cap]=Math.max(v1, v2);
    }

    // using tabulation
        
    private static int unboundKSTab(int[] values,int[] wts,int cap) {
        int[] dp = new int[cap+1];
        
        for(int i = 0; i < wts.length; i++){
            for(int c = wts[i]; c <= cap; c++){
                // yes call
                int v1 = dp[c];
                
                // no call
                int v2 = dp[c-wts[i]] + values[i];
                
                dp[c] = Math.max(v1,v2);
            }
        }
        return dp[cap];
    }

    
    private static int unboundKSTab2(int[] values,int[] wts,int cap) {
        int[] dp = new int[cap+1];
        
        for(int bagc=0; bagc <= cap; bagc++) {
            int max = 0;
            for(int i=0; i < wts.length; i++) {
                if(wts[i] <= bagc){
                    int rbagc = bagc - wts[i];
                    int rbagv = dp[rbagc];
                    int tbagv = rbagv + values[i];
                    
                    if(tbagv > max) {
                        max = tbagv;
                    }
                }
            }
            dp[bagc] = max;
        }
        return dp[cap];
    }
}
