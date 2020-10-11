package bitmanupulation;

import java.util.Scanner;

public class _28ReverseBitUsingBitManupulation {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n =  scn.nextInt();
        int rev = 0;
        int j = 0;
        boolean flag = false;
        for (int i = 31; i >= 0 ; i--) {
            int mask = (1 << i);

            if (flag) {
                if((mask & n) != 0) {
                    System.out.print(1);
                    int smask = (1 << j);
                    rev |= smask;
                } else {
                    System.out.print(0);
                }
                j++;
            } else {
                if((mask & n) != 0) {
                    flag = true;
                    int smask = (1 << j);
                    rev |= smask;
                    System.out.print(1);
                    j++;
                }
            }
        }
        System.out.println();
        System.out.println(rev);
    }
}
