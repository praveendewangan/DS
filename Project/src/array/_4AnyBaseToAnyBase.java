package array;

import java.util.Scanner;

public class _4AnyBaseToAnyBase {
    public static void main(String[] args) {
        System.out.println("Enter number ::");
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();
        System.out.println("Enter input base :: ");
        int ib = scn.nextInt();
        System.out.println("Enter output base :: ");
        int ob = scn.nextInt();
//        System.out.println("Output :: "+converAnyBase(num,ib,ob));
        int o1 = convertAnyBasetoDecimal(num,ib);
        System.out.println(convertDecimaltoAnyBase(o1,ob));
    }

    private static int convertDecimaltoAnyBase(int val,int base) {
        int output = 0;
        int rem = 0;
        int counter = 0;
        int p = 1;
        while (val != 0) {
            rem = val % base;
            val = val / base;
//            output += rem * Math.pow(10,counter);
//            counter++;
            output += rem * p;
            p = p * 10;
        }
        return output;
    }
    private static int convertAnyBasetoDecimal(int val,int base) {
        int output = 0;
        int rem = 0;
        int p = 1;
        while (val != 0) {
            rem = val % 10;
            val = val / 10;
            output += rem * p;
            p = p * base;
        }
        return output;
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
