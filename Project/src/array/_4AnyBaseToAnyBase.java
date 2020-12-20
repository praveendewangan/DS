package array;

import java.util.Scanner;

public class AnyBaseToAnyBase {
    public static void main(String[] args) {
        System.out.println("Enter number ::");
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();
        System.out.println("Enter input base :: ");
        int ib = scn.nextInt();
        System.out.println("Enter output base :: ");
        int ob = scn.nextInt();
        System.out.println("Output :: "+converAnyBase(num,ib,ob));
    }

    private static int converAnyBase(int num,int ib,int ob){
        int output = 0;
        int rem = 0;
        int p = 1;
        while (num != 0) {
            rem = num % ob;
            num = num / ob;
            output += rem * p;
            p = p * ib;
        }
        return output;
    }
}
