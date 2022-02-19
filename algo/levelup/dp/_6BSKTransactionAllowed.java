import java.util.*;
public class _6BSKTransactionAllowed {
    public void solve(int[] a) {
        Scanner scn = new Scanner(System.in);
        int k = scn.nextInt();
        int n = scn.nextInt();
        int[][] dp = new int[k+1][n];

        // O(n^3)
        /**
         *  for (int t = 1; t <= k; t++) {

            for (int d = 1; d < a.length; d++) {
                int max = dp[t][d-1];
                for(int pd = 0; pd < d; pd++){
                    int ptillpd = dp[t-1][pd];
                    int ptth = a[d] - a[pd];
                    if(ptillpd + ptth > max) {
                        max = ptillpd + ptth;
                    }
                }
                dp[t][d] = max;
            }
        }
        System.out.println(dp[k][n-1]);
         * 
         */

         // O(n^2)
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
