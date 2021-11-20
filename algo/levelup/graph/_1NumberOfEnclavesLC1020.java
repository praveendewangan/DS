import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;

class _1NumberOfEnclavesLC1020 {

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] st = br.readLine().split(" ");
    int m = Integer.parseInt(st[0]);
    int n = Integer.parseInt(st[1]);

    int[][] arr = new int[m][n];

    for (int i = 0; i < m; i++) {
      st = br.readLine().split(" ");
      for (int j = 0; j < n; j++) {
        arr[i][j] = Integer.parseInt(st[j]);
      }
    }

    System.out.println(numEnclaves(arr));

  }

  public static int numEnclaves(int[][] arr) {
        // first row
        for(int c = 0; c < arr[0].length; c++){
            if(arr[0][c] == 1)
                dfs(arr,0,c);
        }
        // last row
        for(int c = 0; c < arr[0].length; c++){
            if(arr[arr.length-1][c] == 1)
                dfs(arr,arr.length-1,c);
        }
        
        // first col
        for(int r = 0; r < arr.length; r++){
            if(arr[r][0] == 1)
                dfs(arr,r,0);
        }
        
        // last col
        for(int r = 0; r < arr.length; r++){
            if(arr[r][arr[0].length-1] == 1)
                dfs(arr,r,arr[0].length-1);
        }
        int count = 0;
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[0].length; j++) {
                if(arr[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
  }
  static int[] xdir = {-1,0,1,0};
  static int[] ydir = {0,1,0,-1};
  private static void dfs(int[][] grid,int x,int y) {
      grid[x][y] = 0;
      
      for(int d=0; d < 4; d++) {
          int r = x + xdir[d];
          int c = y + ydir[d];
          if(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1) {
              dfs(grid,r,c);
          }
      }
  }

}