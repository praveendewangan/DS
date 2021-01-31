package practice.arrays;

import java.util.Scanner;

public class _26BuyAndSellTwoTransaction {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for(int i=0 ; i < n ; i++) {
            a[i] = scn.nextInt();
        }
        int least = a[0];
        int[] dpl = new int[n];
        int maxpst = 0;
        for(int i=1;i<n;i++) {
            if(a[i] < least){
                least = a[i];
            }
            maxpst = a[i] - least;
            if(maxpst > dpl[i-1]){
                dpl[i] = maxpst; 
            } else {
                dpl[i] = dpl[i-1];
            }
        }

        int maxat = a[n-1];
        int mpibt = 0;
        int[] dpr = new int[n];
        for(int i=n-2;i >=0 ;i--) {
            if(a[i] > maxat) {
                maxat = a[i];
            }
            mpibt = a[i] - maxat;
            if(mpibt > dpr[i+1]){
                dpr[i] = mpibt;
            } else {
                dpr[i] = dpr[i+1];
            }
        }
        int op = 0;
        for(int i=0; i < n;i++) {
            if(dpl[i] + dpr[i] > op) {
                op = dpl[i] + dpr[i];
            }
        }
        System.out.println(op);
    }
}
