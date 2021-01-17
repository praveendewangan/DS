package dynamicprogramsLU;

import java.util.Scanner;

public class _3LongestBitonicSubSequence {


    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }
        int[] lis = new int[n];
        int[] lds = new int[n];
        int oamax = 0;
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (a[j] <= a[i]) {
                    if (lis[j] > max) {
                        max = lis[j];
                    }
                }
            }
            lis[i] = max + 1;
        }
        for (int i = n - 1; i >= 0; i--) {
            int max = 0;
            for (int j = n - 1; j > i; j--) {
                if (a[j] <= a[i]) {
                    if (lds[j] > max) {
                        max = lds[j];
                    }
                }
            }
            lds[i] = max + 1;
        }
        for (int i = 0; i < n; i++) {
            if ((lis[i] + lds[i] - 1) > oamax) {
                oamax = (lis[i] + lds[i] - 1);
            }
        }
        System.out.println(oamax);
    }


}
