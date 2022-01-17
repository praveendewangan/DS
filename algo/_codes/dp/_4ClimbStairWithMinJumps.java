import java.io.*;
import java.util.*;

public class _4ClimbStairWithMinJumps {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for(int i = 0;i < n; i++) {
            a[i] = scn.nextInt();
        }
        int[] dp = new int[n+1];
        System.out.println(solve(0,n,a,dp));
        // System.out.println(solve(n,a,dp));
    }
    
    private static int solve(int i,int n,int[] jumps,int[] dp) {
        if(i == n) {
            dp[i] = 0;
            return dp[i];
        }
        
        if(dp[i] != 0) {
            return dp[i];
        }
        int count = n;
        for(int jump = 1; jump <= jumps[i] && jump + i <= n; jump++) {
            count = Math.min(count,solve(i+jump,n,jumps,dp));
        }
        dp[i] = count+1;
        return dp[i];
    }
    
    private static int solve(int n,int[] jumps,int[] dp) {
        for(int i = n; i>= 0; i--) {
            if(i == n) {
                dp[i] = 0;
                continue;
            }
            
            int count = n;
            for(int jump = 1; jump <= jumps[i] && jump + i <= n; jump++) {
                count = Math.min(count,dp[i+jump]);
            }
            if(count == n) {
                dp[i] = 1;
            } else {
                dp[i] = count+1;
            }
            
        }
            return dp[0];
    }
    private int helperDp(int[] nums,int n) {
        // Leetcode 45
        int[] dp = new int[n];
        // i = n-1 since for nth position, jump will be zero to reach destination which is n itself
        Arrays.fill(dp,n);
        dp[n-1] = 0;
        for(int i = n-2; i >= 0; i--){
            
            int count = n;
            for(int jump = 1; jump <= nums[i] && jump + i < n; jump++) {
                count = Math.min(count,dp[i+jump]);
            }
            if(count != n) {
                dp[i] = count+1;
            }
        }
        // System.out.print("[");
        // for(int val : dp) {
        //     System.out.print(" "+val);
        // }
        // System.out.println("]");
        return dp[0];
    }

}
