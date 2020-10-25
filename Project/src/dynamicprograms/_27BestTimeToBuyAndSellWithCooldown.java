package dynamicprograms;

import java.util.Scanner;

public class _27BestTimeToBuyAndSellWithCooldown {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }
        int obsp = -a[0];
        int ossp = 0;
        int ocsp = 0;

        for (int i = 1; i < a.length; i++) {
            int nbsp = 0;
            int nssp = 0;
            int ncsp = 0;

            if(ocsp - a[i] > obsp){
                nbsp = ocsp - a[i];
            } else {
                nbsp = obsp;
            }

            if(obsp + a[i] > ossp) {
                nssp = obsp + a[i];
            } else {
                nssp = ossp;
            }

            if(ossp > ocsp) {
                ncsp = ossp;
            } else {
                ncsp = ocsp;
            }

            obsp = nbsp;
            ossp = nssp;
            ocsp = ncsp;
        }

        System.out.println(ossp);
    }
}
