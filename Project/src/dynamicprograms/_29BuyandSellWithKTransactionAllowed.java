package dynamicprograms;

import java.util.Scanner;

public class _29BuyandSellWithKTransactionAllowed {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        int[][] dp = new int[k+1][n];

        for (int t = 1; t <= k; t++) {
            int max = Integer.MIN_VALUE;

            for (int d = 1; d < a.length; d++) {
                if(dp[t-1][d-1] - a[d-1] > max) {
                    max = dp[t-1][d-1] - a[d-1];
                }
                if(max + a[d] > dp[t][d-1]) {
                    dp[t][d] = max + a[d];
                } else {
                    dp[t][d] = dp[t][d-1];
                }
            }
        }
        System.out.println(dp[k][n-1]);
    }
}
