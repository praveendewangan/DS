package recursion;

import java.util.Scanner;

public class PowerLinear {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int n = scn.nextInt();
        System.out.println(print(x,n));
    }
    /*private static int print(int x,int n) {
        if(n < 1) return 1;
        return x * print(x,n -1);
    }*/

    private static int print(int x,int n) {
        if(n == 1) return x;
        int power = print(x,n/2);
        power = power * power;
        if (n % 2 != 0) {
            power = power * x;
        }
        return power;
    }
}
