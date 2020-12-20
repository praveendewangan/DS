package array;

import java.util.Scanner;

public class _5AnyBaseAddition {
    public static void main(String[] args) {
        System.out.println("Enter first value ::");
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        System.out.println("Enter second value ::");
        int n1 = scn.nextInt();
        System.out.println("Enter base value ::");
        int n2 = scn.nextInt();
        System.out.println("Output :: "+add(n1,n2,b));
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
//            op += check(r1,r2,c,b) * p;
            int d = r1 + r2 + c;
            c = d / b;
            d = d % b;
            op += d * p;
            p = p * 10;
//            if(r1 + r2 + c > b) {
//                c = 1;
//            } else {
//                c = 0;
//            }
        }
//        if(c == 1){
//            op += c * p;
//        }
        return op;
    }
//    private static int check(int n1, int n2, int c, int b){
//        int temp = n1 + n2 + c;
//        if(temp > b){
//            return temp - b;
//        }
//        return temp;
//    }
}
