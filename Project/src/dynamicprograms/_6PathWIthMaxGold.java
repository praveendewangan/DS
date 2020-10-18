package dynamicprograms;

import java.util.Scanner;

public class _6PathWIthMaxGold {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n =  scn.nextInt();
        int m =  scn.nextInt();

        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = scn.nextInt();
            }
        }

        int[][] dp = new int[n][m];

        for (int j = dp[0].length - 1; j >= 0 ; j--) {
            for (int i = dp.length - 1; i >= 0 ; i--) {
                if(j == dp[0].length - 1){
                    dp[i][j] = a[i][j];
                } else if(i == 0) {
                    dp[i][j] = Math.max(dp[i][j+1],dp[i+1][j+1]) + a[i][j];
                } else if(i == dp.length - 1) {
                    dp[i][j] = Math.max(dp[i][j+1],dp[i-1][j+1]) + a[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i][j+1],Math.max(dp[i-1][j+1],dp[i+1][j+1])) + a[i][j];
                }
            }
        }
        int max = dp[0][0];

        for (int i = 0; i < dp.length ; i++) {
            if(dp[i][0] > max) {
                max = dp[i][0];
            }
        }
        System.out.println(max);
    }
}
