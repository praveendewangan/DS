package dynamicprograms;

import java.util.Scanner;

public class _18PaintHouse2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int c = scn.nextInt();

        int[][] a = new int[n][c];
        int[][] dp = new int[n][c];
        int least = Integer.MAX_VALUE;
        int sleast = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < c; j++) {
                a[i][j] = scn.nextInt();
                if(i == 0){
                    dp[i][j] = a[i][j];
                    if(dp[i][j] <= least){
                        sleast = least;
                        least = dp[i][j];
                    } else if(dp[i][j] <= sleast) {
                        sleast = dp[i][j];
                    }
                }
            }
        }

        for (int i = 1; i < n; i++) {
            int nleast = Integer.MAX_VALUE;
            int nsleast = Integer.MAX_VALUE;
            for (int j = 0; j < c; j++) {
                if(dp[i-1][j] == least){
                    dp[i][j] = a[i][j] + sleast;
                } else {
                    dp[i][j] = a[i][j] + least;
                }

                if(dp[i][j] <= nleast){
                    nsleast = nleast;
                    nleast = dp[i][j];
                } else if(dp[i][j] <= nsleast) {
                    nsleast = dp[i][j];
                }
            }
            least = nleast;
            sleast = nsleast;
        }

        System.out.println(least);



    }
}
