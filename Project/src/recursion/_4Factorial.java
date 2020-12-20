package recursion;

import java.util.Scanner;

public class _4Factorial {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(print(n));
    }
    private static int print(int n) {
        if(n <= 1) return n;
        return n * print(n -1);
    }
}
