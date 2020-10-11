package bitmanupulation;

import java.util.Scanner;

public class _24SwapAllOddAndEvenBits {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int odm = 0x55555555;
        int evm = 0xAAAAAAAA;

        int odds = (n & odm);
        int evens = (n & evm);

        odds <<= 1;
        evens >>= 1;

        n = odds | evens;
        System.out.println(n);
    }
}
