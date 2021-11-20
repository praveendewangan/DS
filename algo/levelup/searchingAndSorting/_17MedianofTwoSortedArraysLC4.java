import java.util.*;
import java.io.*;

public class _17MedianofTwoSortedArraysLC4 {

    public static double find(int[]a1,int[]a2) {
        if(a2.length < a1.length) return find(a2,a1);
        int n1 = a1.length;
        int n2 = a2.length;
        int lo = 0;
        int hi = n1;
        
        while(lo <= hi) {
            int cut1 = (lo+hi)/2;
            int cut2 = (n1+n2+1)/2 - cut1;
            
            int l1 = cut1 == 0 ? Integer.MIN_VALUE : a1[cut1-1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : a2[cut2-1];
            
            int r1 = cut1 == n1 ? Integer.MAX_VALUE : a1[cut1];
            int r2 = cut2 == n2 ? Integer.MAX_VALUE : a2[cut2];
            
            if(l1 <= r2 && l2 <= r1) {
                if((n1+n2) % 2 == 0) {
                    return (Math.max(l1,l2)+ Math.min(r1,r2))*1.0/2;
                } else {
                    return Math.max(l1,l2);
                }
            } else if(l1 > r2) {
                hi = cut1 - 1;
            } else {
                lo = cut1 + 1;
            }
        }
        
        return 0;
    }

    public static void main(String[]args) {
        Scanner scn = new Scanner(System.in);

        //input work
        int n1 = scn.nextInt();
        int[]a = new int[n1];

        for(int i=0;i < n1;i++){
            a[i] = scn.nextInt();
        }

        int n2 = scn.nextInt();
        int[]b = new int[n2];

        for(int i=0; i < n2;i++) {
            b[i] = scn.nextInt();
        }

        double median = find(a,b);
        System.out.println(median);
    }
}