package bitmanupulation;

import java.util.Scanner;

public class _22CheckPowerOfTwo {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int val = n & (n - 1);
        if(val == 0) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}
