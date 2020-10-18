package dynamicprograms;

import java.util.Scanner;

public class _1Fibonacci {
    private static int fib(int n) {
        if(n == 0 || n == 1) {
            return n;
        }
        int a = fib(n-1);
        int b = fib(n-2);
        return a+b;
    }
    private static int fibmemo(int n,int[] qb) {
        if (n == 0 || n == 1) {
            return n;
        }
        if(qb[n] != 0) {
            return qb[n];
        }
        int a = fib(n-1);
        int b = fib(n-2);
        qb[n] = a+b;
        return a+b;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
//        System.out.println(fib(n));
        System.out.println(fibmemo(n,new int[n+1]));
    }
}
