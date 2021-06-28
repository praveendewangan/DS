import java.io.*;
import java.util.*;

public class _1Fibonacci{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] dp = new int[n+1];
    System.out.println(fibonaci(n,dp));
 }
 
 private static int fibonaci(int n,int[] dp) {
     if(n == 0 || n == 1) {
         dp[n] = n;
         return dp[n];
     }
     if(dp[n] != 0){
         return dp[n];
     }
     int n1 = fibonaci(n-1,dp);
     int n2 = fibonaci(n-2,dp);
     dp[n] = n1 + n2;
     return dp[n];
 }
//  Using tabulation
    private static int fibonaciWithTabulation(int n,int[] dp) {
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

// Using two variables
    private static int fibonaciWithTwoVariables(int n) {
        int a = 0;
        int b = 1;
        while(n-- > 0) {
            int c = a + b;
            a = b;
            b = c;
        }
        return a;
    }
}
