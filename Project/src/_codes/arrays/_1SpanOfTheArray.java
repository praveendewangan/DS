package _codes.arrays;

import java.util.Scanner;

public class _1SpanOfTheArray {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int[] a = new int[n];
        for(int i=0; i < n;i++){
            a[i] = scn.nextInt();
        }
        int max = a[0];
        int min = a[0];
        
        for(int i=1; i < n;i++) {
            if(a[i] > max) {
                max = a[i];
            }
            if(a[i] < min) {
                min = a[i];
            }
        }
        System.out.println(max-min);
     }
}
