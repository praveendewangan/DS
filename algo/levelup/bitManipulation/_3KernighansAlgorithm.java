import java.io.*;
import java.util.*;

public class _3KernighansAlgorithm {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    System.out.println(countSetBit(n));
  }
   // kernighan's algorithm
    private static int countSetBit(int n) {
        int count = 0;
        while(n != 0) {
            int rsbm = (n & (-n));
            n = n - rsbm;
            count++;
        }
        return count;
    }

}