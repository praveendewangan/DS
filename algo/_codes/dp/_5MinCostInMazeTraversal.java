import java.io.*;
import java.util.*;

public class _5MinCostInMazeTraversal {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] a = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                a[i][j] = scn.nextInt();
            }
        }
        
        // System.out.println(mincostRec(a,0,0));
        // System.out.println(mincostDP(a,0,0,new int[n][m]));
        // System.out.println(mincostDP(a,0,0,dp));
        System.out.println(mincostTab(a,new int[n][m]));
    }
    
    private static int mincostRec(int[][] maze,int r,int c) {
        if(r == maze.length-1 && c == maze[0].length-1) {
            return maze[r][c];
        }
        int minCost = (int)1e9;
        
        if(c+1 < maze[0].length) { 
            minCost = Math.min(minCost,mincostRec(maze,r,c+1));
        }
        
        if(r+1 < maze.length) { 
            minCost = Math.min(minCost,mincostRec(maze,r+1,c));
        }
        
        return minCost + maze[r][c];
    }
    
    // Using dp
    
    private static int mincostDP(int[][] maze,int r,int c,int[][] dp) {
        if(r == maze.length-1 && c == maze[0].length-1) {
            dp[r][c] = maze[r][c]; 
            return dp[r][c];
        }
        
        if(dp[r][c] != 0) {
            return dp[r][c];
        }
        int minCost = (int)1e9;
        
        if(c+1 < maze[0].length) { 
            minCost = Math.min(minCost,mincostDP(maze,r,c+1,dp));
        }
        
        if(r+1 < maze.length) { 
            minCost = Math.min(minCost,mincostDP(maze,r+1,c,dp));
        }
        dp[r][c] = minCost + maze[r][c]; 
        return dp[r][c];
    }

    // Using Tabulation
    
    private static int mincostTab(int[][] maze,int[][] dp) {
        for(int i=maze.length-1; i >= 0; i--){
            for(int j=maze[0].length-1; j >= 0; j--) {
                if(i == maze.length - 1 && j == maze[0].length-1) {
                    dp[i][j] = maze[i][j];
                } else if(i == maze.length - 1) {
                    dp[i][j] = maze[i][j] + dp[i][j+1];
                } else if(j == maze[0].length - 1) {
                    dp[i][j] = maze[i][j] + dp[i+1][j];
                } else {
                    dp[i][j] = maze[i][j] + Math.min(dp[i][j+1],dp[i+1][j]);
                }
                    
            }
        }
        return dp[0][0];
    }

    // Print min path
    private static void path(int[][] dp,int r,int c,String psf) {
        if(r == dp.length-1 && c == dp[0].length - 1) {
            System.out.println(psf);
        } else if(r == dp.length-1) {
            path(dp, r, c+1, psf+"R");
        } else if(c == dp[0].length - 1) {
            path(dp, r+1, c, psf+"D");
        } else {
            if(dp[r][c+1] == dp[r+1][c]) {
                path(dp, r, c+1, psf+"R");
                path(dp, r+1, c, psf+"D");
            } else if(dp[r][c+1] < dp[r+1][c]) {
                path(dp, r, c+1, psf+"R");
            } else {
                path(dp, r+1, c, psf+"D");
            }
        }
    }
}
