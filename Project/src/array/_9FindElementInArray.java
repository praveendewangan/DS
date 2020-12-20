package array;

import java.util.Scanner;

public class _9FindElementInArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }
        int f = scn.nextInt();

        for (int i = 0; i < n; i++) {
            if(a[i] == f){
                System.out.println(i);;
                return;
            }
        }
        System.out.println(-1);
    }
}
