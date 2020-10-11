package bitmanupulation;

import java.util.Scanner;

public class _8AllRepeatingExceptOne {
    private static void solution(int[] a){
        int xnum = 0;
        for (int x : a) {
            xnum = x ^ xnum;
        }
        System.out.println(xnum);
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        solution(arr);
    }
}
