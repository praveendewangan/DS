import java.io.*;
import java.util.*;

public class _15CountEncoding {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(solve(str,0));
        System.out.println(solve(str,0,new int[str.length()+1]));
    }
    
    private static int solve(String str,int idx) {
        if(str.length() == idx) {
            return 1;
        }
        if(str.charAt(idx) == '0') {
            return 0;
        }
        
        int count = 0;
        int n1 = str.charAt(idx)-'0';
        count += solve(str,idx+1);
        if(idx+1 < str.length()) {
            int n = str.charAt(idx+1) - '0';
            int n2 = n1*10 + n;
            if(n2 <= 26) {
                count+= solve(str,idx+2);
            }
        }
        return count;
    }

    // Using memorisation
    
    private static int solve(String str,int idx,int[] dp) {
        if(str.length() == idx) {
            return dp[idx] = 1;
        }
        if(str.charAt(idx) == '0') {
            return 0;
        }
        if(dp[idx] != 0) {
            return dp[idx];
        }
        
        int count = 0;
        int n1 = str.charAt(idx)-'0';
        count += solve(str,idx+1,dp);
        if(idx+1 < str.length()) {
            int n = str.charAt(idx+1) - '0';
            int n2 = n1*10 + n;
            if(n2 <= 26) {
                count+= solve(str,idx+2,dp);
            }
        }
        return dp[idx] = count;
    }

    // Using tabulation
    private static int solveTab(String str) {
        int[] dp = new int[str.length()+1];

        for(int i = str.length(); i >= 0; i--) {
            if(str.length() == i) {
               dp[i] = 1;
               continue;
            }
            if(str.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }
            int count = 0;
            int n1 = str.charAt(i)-'0';
            count += dp[i+1];
            if(i+1 < str.length()) {
                int n = str.charAt(i+1) - '0';
                int n2 = n1*10 + n;
                if(n2 <= 26) {
                    count+= dp[i+2];
                }
            }
            dp[i] = count;
            
        }
        
        return dp[0];
    }
}