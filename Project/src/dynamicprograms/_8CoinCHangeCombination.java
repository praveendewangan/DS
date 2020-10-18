package dynamicprograms;

import java.util.Scanner;

public class _8CoinCHangeCombination {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }
        int amt = scn.nextInt();
        int[] dp = new int[amt + 1];
        dp[0] = 1;

        for (int i = 0; i < a.length; i++) {
            for (int j = a[i]; j < dp.length; j++) {
                dp[j] += dp[j - a[i]];
            }
        }
        System.out.println(dp[amt]);
    }
}
