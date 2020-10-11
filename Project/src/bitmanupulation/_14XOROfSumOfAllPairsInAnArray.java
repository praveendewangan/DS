package bitmanupulation;

import java.util.Scanner;

public class _14XOROfSumOfAllPairsInAnArray {
    private static void solution(int[] a) {
        int res = 0;
        for (int i : a) {
            res = res ^ i;
        }
        res = 2 * res;
        System.out.println(res);
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }
        solution(a);
    }
}
