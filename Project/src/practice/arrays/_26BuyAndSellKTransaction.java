package practice.arrays;

import java.util.Scanner;

public class _26BuyAndSellKTransaction {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for(int i=0; i < n; i++) {
            a[i] = scn.nextInt();
        }

        int k = scn.nextInt();
        int[][] dp = new int[k+1][n];
        for(int i=1;i<=k;i++){
            
            /* %%%%%%%%%%%%%%%%%  First Approtch %%%%%%%%%%%% */
            // for(int j=1;j < n;j++) {
                // int max = dp[i][j-1];
                // for(int pd=0;pd < j;pd++){
                //     int p1 = dp[i-1][pd];
                //     int p2 = a[d] - a[pd];
                //     if(p1+p2 > max){
                //         max = p1+p2;
                //     }
                // }
                // dp[i][j] = max;
                
                
            // }

            
        /* %%%%%%%%%%%%%%%%%  Second Approtch %%%%%%%%%%%% */
            int max = Integer.MIN_VALUE;
            for(int d=0;d < n;d++) {
                if(dp[i-1][d-1] - a[d-1] > max){
                    max = dp[i-1][d-1] + a[d-1];
                }

                if(max + a[d] > dp[i][d-1]) {
                    dp[i][d] = max + a[d];
                } else {
                    dp[i][d] = dp[i][d-1];
                }
            }
        }
        scn.close();
    }
}
