import java.io.*;
import java.util.*;

public class _17MaxSumNonAdjucentElement {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }
        System.out.println(solve(a,a.length-1,0));
        System.out.println(solve(a,a.length-1,0,new int[2][n+1]));
        System.out.println(solve(a));
    }
    // using recusrsion
    private static int solve(int[] a,int i,int status) {
        if(i == -1) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        if(status == 0) {
            max = solve(a,i-1,1) + a[i];
        }
        
        max = Math.max(solve(a,i-1,0),max) ;
        return max;
    }

    // Using memorisation
    private static int solve(int[] a,int i,int status,int[][] dp) {
        if(i == -1) {
            return dp[status][i+1] = 0;
        }
        
        if(dp[status][i+1] != 0) {
            return dp[status][i+1];
        }
        int max = Integer.MIN_VALUE;
        if(status == 0) {
            max = solve(a,i-1,1,dp) + a[i];
        }
        
        max = Math.max(solve(a,i-1,0,dp),max) ;
        return dp[status][i+1] = max;
    }

    // Using tabulation
    private static int solve(int[] a) {
        int n1 = a[0];
        int n2 = 0;
        
        for(int i = 1; i < a.length; i++) {
            int nn1 = n2 + a[i];
            int nn2 = Math.max(n1,n2);
            
            n1 = nn1;
            n2 = nn2;
        }
        return Math.max(n1,n2);
    }
}
