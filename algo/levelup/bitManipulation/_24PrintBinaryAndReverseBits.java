import java.io.*;
import java.util.*;

public class _24PrintBinaryAndReverseBits {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    printBinaryAndReverseDecimal(n);
  }

private static void printBinaryAndReverseDecimal(int n) {
        boolean flag = false;
        int rev = 0;
        int j = 0;
        for(int i = 31; i >= 0; i--) {
            int bm = 1 << i;
            if(flag == true) {
                if((bm & n) != 0) {
                    // bit is ON
                    System.out.print(1);
                    int bm2 = 1 << j;
                    rev = (rev | bm2);
                } else {
                    System.out.print(0);
                }
                j++;
            } else {
                if((bm & n) != 0) {
                    flag = true;
                    // bit is ON
                    System.out.print(1);
                    int bm2 = 1 << j;
                    rev = (rev | bm2);
                    j++;
                } else {
                    // leading zero, skip
                }
            }
        }
        System.out.println("\n" + rev);
    }
}