
import java.io.*;
import java.util.*;

public class _24PartitionIntoSubset {
        
    public static long partitionKSubset(int n, int k) {
        long[][] dp = new long[n+1][k+1];
        
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= i && j <= k; j++) {
                if(j == 0) {
                    dp[i][j] = 0;
                } else if(i == j) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i-1][j-1] + j * dp[i-1][j];
                }
            }
        }
        return dp[n][k];
    }
    
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        
        long res = partitionKSubset(n, k);
        System.out.println(res);
    }
}