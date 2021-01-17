package dynamicprogramsLU;

import java.util.Scanner;

public class _2MaxSumIncreasingSubSequence {


    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for(int i=0;i < n;i++) {
            a[i] = scn.nextInt();
        }
        int[] dp = new int[n];
        int maxSum = 0;

        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j = 0;j < i;j++) {
                if(a[j] < a[i]) {
                    if(dp[j] > sum) {
                        sum = dp[j];
                    }
                }
            }
            dp[i] = sum + a[i];

            if(dp[i] > maxSum) {
                maxSum = dp[i];
            }
        }
        System.out.println(maxSum);
    }


}
