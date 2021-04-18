package _codes.recursion;

import java.util.Scanner;

public class _6PowerLogarithmic {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int n = scn.nextInt();
        int val = power(x,n);
        System.out.println(val);
    }

    public static int power(int x, int n){
        if(n == 0) {
            return 1;
        }
        if(n % 2 != 0){
            int val = power(x,n/2);
            return val * val * x;
        } else {
            int val = power(x,n/2);
            return val * val;
        }
    }
}
