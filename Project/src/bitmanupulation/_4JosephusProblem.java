package bitmanupulation;

import java.util.Scanner;

public class _4JosephusProblem {
    private static int powerOf(int n) {
        int i = 1;
        while (i * 2 <= n) {
            i *= 2;
        }
        return i;
    }
    private static void solution(int n) {
        int x = powerOf(n);
        int l = n - x;
        System.out.println(2*l + 1);
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n =  scn.nextInt();
        solution(n);
    }
}
