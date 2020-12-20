package array;

import java.util.Scanner;

public class _8SpanOfArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if(a[i] > max){
                max = a[i];
            }
            if(a[i] < min) {
                min = a[i];
            }
        }
        System.out.println(max - min);
    }
}
