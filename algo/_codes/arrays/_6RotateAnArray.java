package _codes.arrays;

import java.util.Scanner;

public class _6RotateAnArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        takeInput(a, scn);
        int k = scn.nextInt();
        reverse(a,n-k,n-1);
        reverse(a,0,n-k-1);
        reverse(a,0,n-1);
        display(a);
    }
    private static void display(int[] a) {
        for(int n : a) {
            System.out.println(a);
        }
    }
    private static void reverse(int[] a, int start, int end) {
        while(start < end) {
            int t = a[start];
            a[start] = a[end];
            a[end] = t;
            start++;
            end--;
        }
    }
    private static void takeInput(int[] a,Scanner scn) {
        for(int i = 0; i < a.length; i++) {
            a[i] = scn.nextInt();
        }
    }

}
