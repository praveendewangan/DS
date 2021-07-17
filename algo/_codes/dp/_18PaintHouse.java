import java.io.*;
import java.util.*;

public class _18PaintHouse {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] a = new int[n][3];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 3; j++ ) {
                a[i][j] = scn.nextInt();
            }
        }
        
        // System.out.println(solveRec(a));
        System.out.println(solveRec(a,new int[n+1][3]));
        // System.out.println(solveTab(a));
    }
    
    private static int solveRec(int[][] a) {
        int res = helperRec(a,1,0) + a[0][0];
        res = Math.min(res,helperRec(a,1,1) + a[0][1]);
        res = Math.min(res,helperRec(a,1,2) + a[0][2]);
        return res;
    }
    
    private static int helperRec(int[][] a,int idx,int lc) {
        int res = 0;
        if(idx == a.length) {
            return 0;
        }
        if(lc == 0) {
            // int min = Math.min(a[idx][1],a[idx][2]);
            res = helperRec(a,idx+1,1)+a[idx][1];
            res = Math.min(res,helperRec(a,idx+1,2)+a[idx][2]);
            // res += a[idx][0];
        } else if(lc == 1) {
            // int min = Math.min(a[idx][0],a[idx][2]);
            res = helperRec(a,idx+1,0)+a[idx][0];
            res = Math.min(res,helperRec(a,idx+1,2)+a[idx][2]);
            // res += a[idx][1];
        } else {
            // int min = Math.min(a[idx][0],a[idx][1]);
            res = helperRec(a,idx+1,0)+a[idx][0];
            res = Math.min(res,helperRec(a,idx+1,1)+a[idx][1]);
            // res += a[idx][2];
        }
        return res;
    }
    
    private static int solveRec(int[][] a,int[][] dp) {
        int res = helperRec(a,1,0,dp) + a[0][0];
        res = Math.min(res,helperRec(a,1,1,dp) + a[0][1]);
        res = Math.min(res,helperRec(a,1,2,dp) + a[0][2]);
        return res;
    }
    
    private static int helperRec(int[][] a,int idx,int lc,Integer[][] dp) {
        int res = 0;
        if(idx == a.length) {
            return dp[idx][lc] = 0;
        }
        if(dp[idx][lc] != null) {
            return dp[idx][lc];
        }
       if(lc == 0) {
            // int min = Math.min(a[idx][1],a[idx][2]);
            res = helperRec(a,idx+1,1,dp)+a[idx][1];
            res = Math.min(res,helperRec(a,idx+1,2,dp)+a[idx][2]);
            // res += a[idx][0];
        } else if(lc == 1) {
            // int min = Math.min(a[idx][0],a[idx][2]);
            res = helperRec(a,idx+1,0,dp)+a[idx][0];
            res = Math.min(res,helperRec(a,idx+1,2,dp)+a[idx][2]);
            // res += a[idx][1];
        } else {
            // int min = Math.min(a[idx][0],a[idx][1]);
            res = helperRec(a,idx+1,0,dp)+a[idx][0];
            res = Math.min(res,helperRec(a,idx+1,1,dp)+a[idx][1]);
            // res += a[idx][2];
        }
        return dp[idx][lc] = res;
    }
    
    private static int solveTab(int[][] a) {
        int red = 0;
        int green = 0;
        int blue = 0;
        for(int i = 0;i < a.length; i++){
            int n_red = Math.min(green,blue) + a[i][0];
            
            int n_green = Math.min(red,blue) + a[i][1];
            
            int n_blue = Math.min(red,green) + a[i][2];
            
            red = n_red;
            green = n_green;
            blue = n_blue;
        }
        return Math.min(red,Math.min(green,blue));
    }
    
}