import java.io.*;
import java.util.*;

public class _9LongestBitonicSubsequence {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }
        System.out.println(lbs(a));
    }
    
    private static int lbs(int[] arr) {
        int[] lis_ = lis(arr); // make a function of LIS and LDS which return DP rather than answer
        int[] lds_ = lds(arr);

        int ans = 0;
        for(int i = 0; i < arr.length; i++) {
            ans = Math.max(ans, lis_[i] + lds_[i] - 1);
        }
        return ans;
    }
    private static int[] lis(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = 1;
        for(int i = 1; i < arr.length; i++) {
            int max = 0;
            for(int j = i - 1; j >= 0; j--) {
                if(arr[j] < arr[i]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
        }
        return dp;
    }
    
    private static int[] lds(int[] arr) {
        int[] dp = new int[arr.length];
        dp[arr.length - 1] = 1;
        for(int i = arr.length - 2; i >= 0; i--) {
            int max = 0;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[i] > arr[j]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
        }
        return dp;
    }
}