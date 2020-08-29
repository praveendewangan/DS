package array;

import java.util.Scanner;

public class AnyBaseSubstraction {
    public static void main(String[] args) {
        System.out.println("Enter first value ::");
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        System.out.println("Enter second value ::");
        int n2 = scn.nextInt();
        System.out.println("Enter base value ::");
        int b = scn.nextInt();
        System.out.println("Output :: "+substract(n1,n2,b));
    }
    private static int substract(int n1, int n2, int b) {
        int op = 0;
        int c = 0;
        int r1 = 0;
        int r2 = 0;
        int p = 1;
        while (n1 != 0) {
            r1 = n1 % 10;
            r2 = n2 % 10;
            n1 = n1 / 10;
            n2 = n2 / 10;
            int d =0;
            r1 = r1 + c;
            if(r1 >= r2) {
                c = 0;
                d = r1 - r2;
            } else {
                c = -1;
                d = r1 + b - r2;
            }
            op += d * p;
            p = p * 10;
        }
        return op;
    }
}
