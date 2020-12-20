package array;

import java.util.Scanner;

public class _2DecimalToAnyBase {
    public static void main(String[] args) {
        System.out.println("Enter decimal value :: ");
        Scanner scn = new Scanner(System.in);
        int dVal = scn.nextInt();
        System.out.println("Enter output base :: ");
        int oBase = scn.nextInt();
        System.out.println("Output :: "+convertDecimaltoAnyBase(dVal,oBase));
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
}
