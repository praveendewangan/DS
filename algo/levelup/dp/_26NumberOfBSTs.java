import java.io.*;
import java.util.*;

public class _26NumberOfBSTs{

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n =  scn.nextInt();
        System.out.println(catalan(n));
     }
     
     private static int catalan(int n) {
         if(n == 0 || n == 1) return 1;
         int[] dp = new int[n+1];
         dp[0] = 1;
         dp[1] = 1;
         
         for(int i = 2; i <= n; i++){
             int i1 = 0;
             int i2 = i-1;
             int sum = 0;
             for(; i1 < i; i1++, i2--) {
                 sum += dp[i1] * dp[i2];
             }
             dp[i] = sum;
         }
         return dp[n];
     }

}