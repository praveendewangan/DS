package _codes.arrays;

import java.util.Scanner;

public class _2FindElementInArray {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int[] a = new int[n];
        for(int i=0 ;i < n; i++){
            a[i] = scn.nextInt();
        }
        int f = scn.nextInt();
        int idx = -1;
        for(int i = 0; i < n; i++){
            if(a[i] == f) {
                idx = i;
                break;
            }
        }
        
                System.out.println(idx);
     }
}
