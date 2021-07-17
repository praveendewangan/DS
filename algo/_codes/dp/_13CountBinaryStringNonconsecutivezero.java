import java.io.*;
import java.util.*;

public class _13CountBinaryStringNonconsecutivezero{

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(solve(n,1));
        System.out.println(solve(n,1,""));
        System.out.println(solveMemo(n,1,"",new int[n+1][2]));
        
        System.out.println(solveTab1(n));
        System.out.println(solveTab2(n));
     }
    //  Using recursion 
     private static int solve(int n,int lsn) {
         if(n == 0) {
             return 1;
         }
         int count = 0;
         count += solve(n-1,1);
         if(lsn == 1) {
             count += solve(n-1,0);
         }
         return count;
     }

     private static int solve(int n,int lsn,String psf) {
        if(n == 0) {
            System.out.println(psf);
            return 1;
        }
        int count = 0;
        count += solve(n-1,1,psf+"1");
        if(lsn == 1) {
            count += solve(n-1,0,psf+"0");
        }
        return count;
    }

    // using memorisation 
    
    private static int solveMemo(int n,int lsn,String psf,int[][] dp) {
        if(n == 0) {
            System.out.println(psf);
            return dp[n][lsn] = 1;
        }

        if(dp[n][lsn] != 0) {
            return dp[n][lsn];
        }

        int count = 0;
        count += solveMemo(n-1,1,psf+"1",dp);
        if(lsn == 1) {
            count += solveMemo(n-1,0,psf+"0",dp);
        }
        return dp[n][lsn] = count;
    }

    // Using tabulation
    private static int solveTab1(int n) {
        int[][] dp = new int[2][n+1];
        dp[0][1] = 1;
        dp[1][1] = 1;
        for(int i=2; i <= n; i++){
            dp[0][i] = dp[1][i-1];
            dp[1][i] = dp[1][i-1] + dp[0][i-1];
        }
        return dp[0][n] + dp[1][n];
    }

    private static int solveTab2(int n) {
        int a = 1;
        int b = 1;
        for(int i = 2; i <= n; i++) {
            int c = a;
            a = b;
            b += c;
        }
        return a+b;
    }

}