import java.io.*;
import java.util.*;

public class _29BuyandSellTwoTransactionAllowed {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }

        int mpist = 0;
        int least = a[0];
        int[] dpl = new int[a.length];

        for (int i = 1; i < a.length; i++) {
            // if(a[i] < least) {
            //     least = a[i];
            // }
            least = Math.min(least,a[i]);

            mpist = a[i] - least;
            // if(mpist > dpl[i-1]) {
            //     dpl[i] = mpist;
            // } else {
            //     dpl[i] = dpl[i-1];
            // }
            dpl[i] = Math.max(mpist,dpl[i-1]);
        }

        int mpibt = 0;
        int maxat = a[a.length-1];
        int[] dpr = new int[a.length];

        for (int i = a.length - 2; i >= 0; i--) {
            // if(a[i] > maxat) {
            //     maxat = a[i];
            // }
            maxat = Math.max(maxat,a[i]);
            mpibt = maxat - a[i];
            // if (mpibt > dpr[i+1]) {
            //     dpr[i] = mpibt;
            // } else {
            //     dpr[i] = dpr[i+1];
            // }
            dpr[i] = Math.max(mpibt,dpr[i+1]);
        }

        int op = 0;
        for (int j = 0; j < a.length; j++) {
            // if(dpl[j] + dpr[j] > op) {
            //     op = dpl[j] + dpr[j];
            // }
            op = Math.max(op,dpl[j] + dpr[j]);
        }
        System.out.println(op);

    }

}
