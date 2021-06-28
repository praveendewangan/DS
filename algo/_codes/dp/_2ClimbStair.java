import java.io.*;
import java.util.*;

public class _2ClimbStair {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] dp = new int[n+1];
        System.out.println(solve(0,n,dp));
    }
    
    private static int solve(int idx,int n,int[] dp) {
        if(idx > n) {
            return 0;
        }
        if(n == idx){
            dp[idx] = 1;
            return dp[idx];
        }
        if(dp[idx] != 0) {
            return dp[idx];
        }
        int n1 = solve(idx+1,n,dp);
        int n2 = solve(idx+2,n,dp);
        int n3 = solve(idx+3,n,dp);
        dp[idx] = n1 + n2 + n3;
        return dp[idx];
    }
    // Approch 2;
    
    private static int solve(int n,int[] dp) {
        
        if(n == 0){
            dp[n] = 1;
            return dp[n];
        }
        if(dp[n] != 0) {
            return dp[n];
        }
        int count = 0;
        for(int i = 1; i <= 3; i++) {
            if(n-i >= 0)
                count += solve(n-i,dp);
        }
        
        dp[n] = count;
        return dp[n];
    }

    // Using Tabulation
    
    private static int solveTab(int n,int[] dp) {
        dp[0] = 1;
        for(int i = 1; i <= n; i++) {
            int count = 0;
            for(int j = 1; j <= 3; j++) {
                if(i-j >= 0)
                    count += dp[i-j];
                
            }
            dp[i] = count;
        }
        
        return dp[n];
    }
    

}
