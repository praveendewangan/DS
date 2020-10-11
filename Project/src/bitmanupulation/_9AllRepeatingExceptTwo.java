package bitmanupulation;

import java.util.Scanner;

public class _9AllRepeatingExceptTwo {
    private static void solution(int[] arr) {
        int xnum = 0;
        for (int a : arr) {
            xnum = xnum ^ a;
        }
        int rmsb = xnum & -xnum;
        int x = 0;
        int y = 0;
        for (int val : arr) {
            if((val & rmsb) == 0) {
                x = x ^ val;
            } else {
                y = y ^ val;
            }
        }
        System.out.println(x);
        System.out.println(y);
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n =  scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        solution(arr);
    }
}
