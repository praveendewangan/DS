package dynamicprogramsLU;

import java.util.Scanner;

public class _1LongestIncreasingSequence {


    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        Integer[] a = new Integer[n];
        for(int i = 0; i < n;i++) {
            a[i] = scn.nextInt();
        }
        int[] dp = new int[n];
        int oamax = 0;
        for(int i = 0;i < n;i++){
            int max = 0;
            for(int j = 0; j < i;j++) {
                if(a[j] < a[i]){
                    if(dp[j] > max){
                        max = dp[j];
                    }
                }
            }
            dp[i] = max + 1;
            if(dp[i] > oamax){
                oamax = dp[i];
            }
        }
        System.out.println(oamax);
    }


}
