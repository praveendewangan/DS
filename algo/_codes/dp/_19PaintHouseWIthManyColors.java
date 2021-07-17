
import java.io.*;
import java.util.*;

public class _19PaintHouseWIthManyColors {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] a = new int[n][m];
        
        for(int i= 0; i < a.length; i++) {
            for(int j = 0; j < a[0].length; j++){
                a[i][j] = scn.nextInt();
            }
        }
        
        System.out.println(solve(n,m,a));
    }
    
    private static int solve(int n, int m, int[][] a) {
        int min = Integer.MAX_VALUE;
        int smin = Integer.MAX_VALUE;
        
        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++) {
            int nmin = Integer.MAX_VALUE;
            int nsmin = Integer.MAX_VALUE;
            for(int j = 0; j < m; j++) {
                if(i == 0) {
                    dp[i][j] = a[i][j];
                } else {
                    if(dp[i-1][j] != min) {
                        dp[i][j] = a[i][j] + min;
                    } else {
                        dp[i][j] = a[i][j] + smin;
                    }
                }
                if(dp[i][j] <= nmin) {
                    nsmin = nmin;
                    nmin = dp[i][j];
                } else if(dp[i][j] < nsmin){
                    nsmin = dp[i][j];
                }
            }
            min = nmin;
            smin = nsmin;
        }
        return min;
    }
}