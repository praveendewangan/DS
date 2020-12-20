package recursion;

import java.util.Scanner;

public class _1PrintDecreasing {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        print(scn.nextInt());
    }
    private static void print(int n) {
        System.out.println(n);
        if(n - 1 == 0 ) return;
        print(n-1);
    }
}
