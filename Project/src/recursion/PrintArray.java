package recursion;

import java.util.Scanner;

public class PrintArray {
    public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int[] n = {1,2,3,4,5};
     print(n,0);
     //reversePrint(n,0);
    }
    private static void print(int[] a,int n){
        if (n == a.length) return;
        System.out.println(a[n]);
        print(a,n+1);
        System.out.println(a[n]);
    }
    private static void reversePrint(int[] a,int n){
        if (n == a.length) return;
        reversePrint(a,n+1);
        System.out.println(a[n]);
    }
}
