package array;

import java.util.Scanner;

public class _7AnyBaseMultiply {
    public static void main(String[] args) {
        System.out.println("Enter first value :: ");
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        System.out.println("Enter second value :: ");
        int n2 = scn.nextInt();
        System.out.println("Enter base value :: ");
        int b =  scn.nextInt();
        System.out.println("Output :: "+getMultiply(n1,n2,b));
    }

    private static int getMultiply(int n1,int n2,int b) {
        int op = 0;
        int r2 = 0;
        int p = 1;
        while (n2 != 0 ) {
            r2 = n2 % 10;
            n2 = n2 / 10;
            int d = getMultiplyWithSingleDigit(n1,r2,b);
            op = add(op,d * p,b);
            p = p * 10;
        }
        return op;
    }
    private static int getMultiplyWithSingleDigit(int n1, int n, int b) {
        int op = 0;
        int c = 0;
        int p = 1;
        int r = 0;
        while (n1 != 0 || c != 0) {
            r = n1 % 10;
            n1 = n1 / 10;
            int d = r * n + c;
            c = d / b;
            d = d % b;
            op += d * p;
            p = p * 10;
        }
        return op;
    }
    private static int add(int n1, int n2, int b) {
        int op = 0;
        int c = 0;
        int r1 = 0;
        int r2 = 0;
        int p = 1;
        while (n1 != 0 || n2 != 0 || c != 0) {
            r1 = n1 % 10;
            r2 = n2 % 10;
            n1 = n1 /10;
            n2 = n2 /10;
            int d = r1 + r2 + c;
            c = d / b;
            d = d % b;
            op += d * p;
            p = p * 10;
        }
        return op;
    }
}
