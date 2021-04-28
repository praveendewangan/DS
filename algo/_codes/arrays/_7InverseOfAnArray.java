package _codes.arrays;

import java.util.Scanner;

public class _7InverseOfAnArray extends Util{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        takeInput(a,scn);
        int[] inv = inverse(a);
    }
    private static int[] inverse(int[] a) {
        int[] inv = new int[a.length];
        for(int i = 0; i < a.length; i++){
            int pos = a[i];
            inv[pos] = i;
        }
        return inv;
    }
}
