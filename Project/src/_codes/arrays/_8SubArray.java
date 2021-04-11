package _codes.arrays;

import java.util.Scanner;

public class _8SubArray extends Util{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        takeInput(a,scn);
        subArray(a);
    }
    private static void subArray(int[] a) {
        for(int sp = 0; sp < a.length; sp++){
            for(int ep = sp; ep < a.length; ep++){
                for(int i = sp; i <= ep; i++){
                    System.out.print(a[i] + "\t");
                }
                System.out.println();
            }
        }
    }
}
