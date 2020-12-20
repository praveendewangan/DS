package recursion;

import java.util.Scanner;

public class _6PrinZigZag {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        fun(n);
    }
    private static void fun(int n) {
        if(n==0) return;
        System.out.print(n + " ");
        fun(n-1);
        System.out.print(n + " ");
        fun(n-1);
        System.out.print(n + " ");
    }
}
