package bitmanupulation;

import java.util.Scanner;

public class _2RightMostSetBit {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int rmsb = n & -n;
        System.out.println(Integer.toBinaryString(rmsb));
    }
}
