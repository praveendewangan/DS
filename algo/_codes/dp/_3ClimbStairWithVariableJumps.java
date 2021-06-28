import java.io.*;
import java.util.*;

public class _3ClimbStairWithVariableJumps {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for(int i = 0;i < n; i++) {
            a[i] = scn.nextInt();
        }
        int[] dp = new int[n+1];
        System.out.println(solve(0,n,a,dp));
    }
    
    private static int solve(int i,int n,int[] jumps,int[] dp) {
        if(i == n) {
            dp[i] = 1;
            return dp[i];
        }
        if(dp[i] != 0) {
            return dp[i];
        }
        int count = 0;
        for(int jump = 1; jump <= jumps[i] && jump+i <=n ; jump++) {
            count += solve(i+jump,n,jumps,dp);
        }
        dp[i] = count;
        return dp[i];
    }

    // Using tabulation
    private static int solveTab(int n,int[] jumps,int[] dp) {
        for(int i = n; i >= 0; i--) {
            if(i == n) {
                dp[i] = 1;
                continue;
            }
            int count = 0;
            for(int jump = 1; jump <= jumps[i] && jump+i <=n ; jump++) {
                count += dp[i+jump];
            }
            dp[i] = count;
        }
        return dp[0];
    }

}