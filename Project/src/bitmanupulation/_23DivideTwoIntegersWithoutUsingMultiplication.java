package bitmanupulation;

import java.util.Scanner;

public class _23DivideTwoIntegersWithoutUsingMultiplication {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int val = (((n << 3) - n) >> 3);
        System.out.println(val);
    }
}
