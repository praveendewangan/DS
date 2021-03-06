package dynamicprogramsLU;
import java.io.*;
import java.util.*;

public class _11LongestPalindromicSubstring {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        boolean[][] dp = new boolean[str.length()][str.length()];
        int count = 0;
        for (int g = 0; g < str.length(); g++) {
            for (int i = 0, j = i + g; j < dp.length; i++, j++) {
                if (g == 0) {
                    dp[i][j] = true;
                } else if (g == 1) {
                    if (str.charAt(i) == str.charAt(j)) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    if (str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                }
                if(dp[i][j]) {
                    count = g + 1;
                }
            }
        }
        System.out.println(count);
    }


}
