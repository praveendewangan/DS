package dynamicprograms;

import java.util.Scanner;

public class _16MaxSumOfNonAdjucentElemensGreedyAlgo {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n =  scn.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }

        int inc = a[0];
        int exc = 0;

        for (int i = 1; i < a.length; i++) {
            int nInc = exc + a[i];
            int nExc = Math.max(inc,exc);

            inc = nInc;
            exc = nExc;
        }
        int ans = Math.max(inc,exc);
        System.out.println(ans);
    }
}
