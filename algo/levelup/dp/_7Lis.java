import java.io.*;
import java.util.*;

public class _7Lis {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }
        System.out.println(lis(a));
    }
    private static int lis(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = 1;
        int ans = 1;
        for(int i = 1; i < arr.length; i++) {
            int max = 0;
            for(int j = i - 1; j >= 0; j--) {
                if(arr[j] < arr[i]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

}