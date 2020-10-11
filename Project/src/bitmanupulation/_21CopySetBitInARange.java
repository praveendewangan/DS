package bitmanupulation;

import java.util.Scanner;

public class _21CopySetBitInARange {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        int b = scn.nextInt();

        int right = scn.nextInt();
        int left = scn.nextInt();

        int mask = (1 << (right - left + 1));
        mask--;
        mask = mask << (left - 1);
        mask = a & mask;
        b = b | mask;
        System.out.println(b);

    }
}
