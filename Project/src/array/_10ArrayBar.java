package array;

import java.util.Scanner;

public class _10ArrayBar {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[] a = new int[scn.nextInt()];
        int max = 0;
        for (int i=0;i < a.length;i++) {
            a[i] = scn.nextInt();
            if(a[i] > max) {
                max = a[i];
            }
        }
        for (int i=max;i >=0;i--) {
            for (int j=0;j<a.length;j++) {
                if(a[j] > i) {
                    System.out.print("*\t");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println("");
        }
    }
}
