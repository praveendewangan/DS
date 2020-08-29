package array;

import java.util.Scanner;

public class AnyBaseToDecimal {
        public static void main(String[] args) {
            System.out.println("Enter input value :: ");
            Scanner scn = new Scanner(System.in);
            int dVal = scn.nextInt();
            System.out.println("Enter output base :: ");
            int oBase = scn.nextInt();
            System.out.println("Output :: "+convertAnyBasetoDecimal(dVal,oBase));
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
}
