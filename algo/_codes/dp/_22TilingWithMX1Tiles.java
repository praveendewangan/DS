import java.io.*;
import java.util.*;

public class _22TilingWithMX1Tiles {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        
        System.out.println(solve(n,m));
    }
    
    private static long solve(int n,int m) {
        long[] dp = new long[n+1];
        
        for(int i = 0; i <= n; i++) {
            if(i < m) {
                dp[i] = 1;
            } else {
                dp[i] = dp[i-1] + dp[i-m];
            }
        }
        return dp[n];
    }
}
