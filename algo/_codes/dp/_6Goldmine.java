
import java.io.*;
import java.util.*;

public class _6Goldmine {

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
        int[][] dp = new int[n][m];    
        for(int i = 0; i < n; i++){
            goldmine(a,i,0,dp);
        }
        
        int num = dp[0][0];
        
        for(int i = 1; i < a.length;i++){
            num = Math.max(num,dp[i][0]);
        }
        System.out.println(num);
    }
    
    private static int goldmine(int[][] maze,int r,int c,int[][] dp) {
        if(c == maze[0].length-1) {
            return maze[r][c];
        }
        int num = 0;
        if(r-1 >= 0 && c+1 < maze[0].length){
            num = Math.max(num,goldmine(maze,r-1,c+1,dp));
        }
        // Can remove below if condition
        if(c+1 < maze[0].length){
            num = Math.max(num,goldmine(maze,r,c+1,dp));
        }
        // can remove c+1 condition
        if(r+1 < maze.length && c+1 < maze[0].length){
            num = Math.max(num,goldmine(maze,r+1,c+1,dp));
        }
        // dp[r][c] = num + maze[r][c];
        return num + maze[r][c];
    }
//  Alternative 
    public static int goldmineHelper_rec(int[][] mine, int x, int y) {
        if(y == mine[0].length - 1) {
            return mine[x][y];
        }

        int cost = 0;
        // top-right
        if(x - 1 >= 0) {
            cost = Math.max(cost, goldmineHelper_rec(mine, x - 1, y + 1));
        }
        // right -> no need for check of y
        cost = Math.max(cost, goldmineHelper_rec(mine, x, y + 1));
        // down-right
        if(x + 1 < mine.length) {
            cost = Math.max(cost, goldmineHelper_rec(mine, x + 1, y + 1));
        }
        return cost + mine[x][y];
    }

    // Using DP
    private static int goldminedp(int[][] maze,int r,int c,int[][] dp) {
        int num = 0;
        if(dp[r][c] != 0) {
            return dp[r][c];
        }
        if(r-1 >= 0 && c+1 < maze[0].length){
            num = Math.max(num,goldminedp(maze,r-1,c+1,dp));
        }
        
        if(c+1 < maze[0].length){
            num = Math.max(num,goldminedp(maze,r,c+1,dp));
        }
        
        if(r+1 < maze.length && c+1 < maze[0].length){
            num = Math.max(num,goldminedp(maze,r+1,c+1,dp));
        }
        dp[r][c] = num + maze[r][c];
        return dp[r][c];
    }
    // Using tabulation
    private static void goldmineTab(int[][] maze) {
        for(int j = maze[0].length-1; j >= 0; j--){
            for(int i = 0; i < maze.length; i++){
                if(i == 0 && j == maze[0].length-1){
                    
                } else if(i == 0) {
                    maze[i][j] += Math.max(maze[i][j+1],maze[i+1][j+1]); 
                } else if(j == maze[0].length-1) {
                    // maze[i][j] += Math.max(maze[i-1][j+1],maze[i+1][j+1]);
                } else {
                    if(i == maze.length-1) {
                    maze[i][j] += Math.max(maze[i-1][j+1],maze[i][j+1]);
                        
                    } else {
                        
                    maze[i][j] += Math.max(maze[i][j+1],Math.max(maze[i-1][j+1],maze[i+1][j+1]));
                    }
                }
            }
        }
    }

    public static int goldmine_tab1(int[][] mine, int x, int y, int[][] dp) {
        int res = 0;
        for(y = mine[0].length - 1; y >= 0; y--) {
            for(x = 0; x < mine.length; x++) {
                if(y == mine[0].length - 1) {
                    dp[x][y] = mine[x][y];
                } else if(x == 0){
                    dp[x][y] = Math.max(dp[x][y + 1], dp[x + 1][y + 1]) + mine[x][y];
                } else if(x == mine.length - 1) {
                    dp[x][y] = Math.max(dp[x][y + 1], dp[x - 1][y + 1]) + mine[x][y];
                } else {
                    dp[x][y] = Math.max(dp[x - 1][ y + 1], Math.max(dp[x][y + 1], dp[x + 1][y + 1])) + mine[x][y];
                }
                res = Math.max(res, dp[x][y]);
            }
        }
        return res;
    }

    public static int goldmine_tab2(int[][] mine, int x, int y, int[][] dp) {
        int profit = 0;
        for(y = mine[0].length - 1; y >= 0; y--) {
            for(x = 0; x < mine.length; x++) {
                if(y == mine[0].length - 1) {
                    dp[x][y] = mine[x][y];
                    profit = Math.max(profit, dp[x][y]);
                    continue;
                }
                int cost = 0;
                // top-right
                if(x - 1 >= 0) {
                    cost = Math.max(cost, dp[x - 1][y + 1]);
                }
                // right -> no need for check of y
                cost = Math.max(cost, dp[x][y + 1]);
                // down-right
                if(x + 1 < mine.length) {
                    cost = Math.max(cost, dp[x + 1][y + 1]);
                }
                dp[x][y] = cost + mine[x][y];
                profit = Math.max(profit, dp[x][y]);
            }
        }
        return profit;
    }


}