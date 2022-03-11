import java.io.*;
import java.util.*;

public class _29CircleAndChords{

    
    public static long NumberOfChords(int n){
        return catalan(n);
    }
      public static void main(String[] args) {
    	Scanner scn = new Scanner(System.in);
        int n =  scn.nextInt();
        System.out.println(catalan(n));
     }
     
     private static long catalan(int n) {
         if(n == 0 || n == 1) return 1;
         long[] dp = new long[n+1];
         dp[0] = 1;
         dp[1] = 1;
         
         for(int i = 2; i <= n; i++){
             int i1 = 0;
             int i2 = i-1;
             long sum = 0;
             for(; i1 < i; i1++, i2--) {
                 sum += dp[i1] * dp[i2];
             }
             dp[i] = sum;
         }
         return dp[n];
     }

}