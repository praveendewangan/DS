package bitmanupulation;

import java.util.Scanner;

public class _19AllRepeatingThriesExceptOne {
    private static void solution(int[] a) {
        int tn = Integer.MAX_VALUE,tnp1 = 0,tnp2 = 0;
        for (int num : a) {
            int cmt = tn & num;
            int cmt1 = tnp1 & num;
            int cmt2 = tnp2 & num;

            tn = tn & (~cmt);
            tnp1 = tnp1 | cmt;

            tnp1 = tnp1 & (~cmt1);
            tnp2 = tnp2 | cmt1;

            tnp2 = tnp2 & (~cmt2);
            tn = tn | cmt2;
        }
        System.out.println(tnp1);
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
