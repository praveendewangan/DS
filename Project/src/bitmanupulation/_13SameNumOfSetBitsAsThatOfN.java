package bitmanupulation;

import java.util.Scanner;

public class _13SameNumOfSetBitsAsThatOfN {
    private static long ncr(long n,long r) {
        if (n < r) {
            return 0;
        }
        long res = 1L;
        for (long i = 0L; i < r; i++) {
            res *= (n-i);
            res /= (i+1);
        }
        return res;
    }
    private static long solution(long n,int csb,int i) {
        if(i == 0) {
            return 0;
        }
        long mask = 1L << i;
        long res = 0;
        if((n & mask) == 0) {
            res = solution(n,csb,i - 1);
        } else {
            long res1 = solution(n,csb - 1,i - 1);
            long res0 = ncr(i,csb);
            res = res0 + res1;
        }
        return res;
    }
    private static int csb(long n) {
        int count = 0;
        while (n > 0) {
            long rsb = n & -n;
            n -= rsb;
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = csb(n);
        System.out.println(solution(n,k,63));
    }
}
