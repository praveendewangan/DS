import java.io.*;
import java.util.*;

public class _22SwapAllOddAndEvenBits {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    System.out.println(swapBits(n));
    
  }
  
  private static int swapBits(int n) {
        int mask1 = 0x5_5_5_5_5_5_5_5;
        int mask2 = 0xA_A_A_A_A_A_A_A;

        // 1. Preserve odd index
        int n1 = (n & mask1);
        // 2. Preserve even index
        int n2 = (n & mask2);
        // 3. left shift in n1
        n1 = (n1 << 1);
        // 4. Right shift in n2
        n2 = (n2 >> 1);
        // 5. res = n1 OR n2
        int res = (n1 | n2);
        return res;
    }

}