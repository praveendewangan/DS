package bitmanupulation;

import java.util.Scanner;

public class _26CheckBinaryStringDivisibleByThree {
    private static void solution(String str) {
        int odd = 0;
        int even = 0;
        for (int i = 0; i < str.length(); i++) {
            int bit = str.charAt(i) - '0';

            if(i % 2 == 0) {
                even += bit;
            } else {
                odd += bit;
            }
        }
        int delta = even - odd;
        if (delta % 11 == 0) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String n = scn.next();
        solution(n);
    }
}
