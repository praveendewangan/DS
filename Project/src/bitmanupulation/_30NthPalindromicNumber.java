package bitmanupulation;

import java.util.Scanner;

public class _30NthPalindromicNumber {
    private static int getRev(int num) {
        int rev = 0;
        while (num != 0) {
            int lb = (num & 1);
            rev |= lb;

            rev <<= 1;
            num >>= 1;
        }
        rev >>= 1;
        return rev;
    }
    private static void solution(int n) {
        int ans = 0;
        int len = 1;
        int count = 1;
        while (count < n) {
            len++;
            int ele = (1 << (len - 1) / 2);
            count += ele;
        }
        count -= (1 << (len - 1) / 2);
        int offset = n - count - 1;
        ans = (1 << (len - 1));
        ans |= (offset << (len / 2));

        int valfr = (ans >> (len / 2));
        int rev = getRev(valfr);
        ans |= rev;

        System.out.println(ans);
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        solution(n);
    }
}
