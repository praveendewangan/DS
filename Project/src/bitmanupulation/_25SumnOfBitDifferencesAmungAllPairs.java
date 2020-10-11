package bitmanupulation;

import java.util.Scanner;

public class _25SumnOfBitDifferencesAmungAllPairs {
    private static void solution(int[] a) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int n : a) {
                if((n & (1 << i)) != 0) {
                    count++;
                }
            }
            int countoff = a.length - count;
            int diff = count * countoff * 2;
            res += diff;
        }
        System.out.println(res);
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = scn.nextInt();
        }
        solution(a);
    }
}
