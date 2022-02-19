import java.io.*;
import java.util.*;

public class _20IsAPowerOf2LC231 {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    System.out.println(isPowerOfTwo(n));
    
  }
  
  public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

}