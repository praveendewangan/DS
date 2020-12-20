package array;

import java.util.Scanner;

public class _15InverseArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[] a = new int[scn.nextInt()];
        for (int i=0;i<a.length;i++) {
            a[i] = scn.nextInt();
        }
        int l=a.length;
        for (int i=0;i<l;i++) {
            int temp = a[i];
            a[temp] = i;
        }
        print(a);
    }
    private static void print(int[] a) {
        for (int i: a
             ) {
            System.out.println(i);
        }
    }
}
