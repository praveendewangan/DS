import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _10ShortestBridgeLC934 {

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[][] arr = new int[n][n];

    for (int i = 0; i < n; i++) {
      String[] st = br.readLine().split(" ");
      for (int j = 0; j < n; j++) {
        arr[i][j] = Integer.parseInt(st[j]);
      }
    }

    System.out.println(shortestBridge(arr));

  }
  static class Pair{
      int x;
      int y;
      Pair(int x,int y) {
          this.x = x;
          this.y = y;
      }
  }

  public static int shortestBridge(int[][] grid) {
    Queue<Pair> q = new LinkedList<>();
    loop1 : for(int i=0; i < grid.length; i++) {
        for(int j=0; j < grid[0].length; j++) {
            if(grid[i][j] == 1) {
                dfsShortestBridge(grid,i,j,q);
                break loop1;
            }
        }
    }
    
    int level = -1;
    while(q.size() > 0) {
        int size = q.size();
        level++;
        while(size-- > 0) {
            Pair rm = q.remove();
            for(int d = 0; d < 4; d++){
                int r = rm.x + xdir[d];
                int c = rm.y + ydir[d];
                if(r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] != -1) {
                    if(grid[r][c] == 1) return level;
                   q.add(new Pair(r,c));
                }
            }
        }
    }
    return level;
  }
  static int[] xdir = {-1,0,1,0};
  static int[] ydir = {0,1,0,-1};
  private static void dfsShortestBridge(int[][] grid,int x,int y,Queue<Pair> q) {
      grid[x][y] = -1;
      q.add(new Pair(x,y));
      for(int d = 0; d < 4; d++){
          int r = x + xdir[d];
          int c = y + ydir[d];
          if(r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == 1) {
              dfsShortestBridge(grid,r,c,q);
          }
      }
      
  }
}
