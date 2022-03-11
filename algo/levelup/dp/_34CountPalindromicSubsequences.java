import java.io.*;
import java.util.*;

public class _34CountPalindromicSubsequences {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(countPalindromicSubsequences(str));
    }

     public static int countPalindromicSubsequences(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int g = 0; g < n; g++){
            for(int i = 0, j = g; j < n; i++,j++) {
                if(g == 0) {
                    dp[i][j] = 1;
                } else if(g == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j) ? 3 : 2;
                } else {
                    if(s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i+1][j] + dp[i][j-1] + 1;
                    } else {
                        dp[i][j] = dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1];
                    }
                }
            }
        }
        return dp[0][n-1];
    }
}