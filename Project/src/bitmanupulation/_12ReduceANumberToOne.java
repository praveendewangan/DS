package bitmanupulation;

import java.util.Scanner;

public class _12ReduceANumberToOne {
    private static void solution(long n) {
        int c = 0;
        while (n != 1) {
            if(n % 2 == 0) {
                n = n / 2;
            } else if(n == 3) {
                n = n - 1;
            } else if((n & 3) == 1) {
                n = n - 1;
            } else if((n & 3) == 3) {
                n = n + 1;
            }
            c++;
        }
        System.out.println(c);
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n =  scn.nextInt();
        solution(n);
    }
}
