import java.io.*;
import java.util.*;

public class _26CountSetBitsInFirstNNaturalNumbers {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    System.out.println(countSetBitInNNaturalNumber(n));
  }

 private static int powerOf2(int n) {
        int x = 0;
        while((1 << x) <= n) {
            x++;
        }
        x--;
        return x;
    }

    public static int countSetBitInNNaturalNumber(int n){
        if(n == 0) return 0;
        int x = powerOf2(n);
        int first = x * (1 << (x - 1));
        int second = n + 1 - (1 << x);
        int recRes = countSetBitInNNaturalNumber(n - (1 << x));
        int res = first + second + recRes;    
        return res;
    }

}