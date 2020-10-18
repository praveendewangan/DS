package dynamicprograms;

import java.util.Scanner;

public class _12CountBinaryStrings {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n =  scn.nextInt();
        /*---- With Array ----*/
        int[] dp0 = new int[n+1];
        int[] dp1 = new int[n+1];
        dp0[1] = 1;
        dp1[1] = 1;

        for (int i = 2; i <= n ; i++) {
            dp1[i] = dp1[i-1]+dp0[i-1];
            dp0[i] = dp1[i-1];
        }

        System.out.println(dp0[n]+dp1[n]);

        /*---- Without Array ----*/
        int once = 1;
        int zeros = 1;

        for (int i = 2; i <= n ; i++) {
            int nzeros = once;
            int nonce = zeros + once;
            zeros = nzeros;
            once = nonce;
        }
        System.out.println(zeros+once);
    }
}
