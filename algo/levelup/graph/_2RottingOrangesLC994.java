import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class _2RottingOrangesLC994 {

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] st = br.readLine().split(" ");
    int n = Integer.parseInt(st[0]);
    int m = Integer.parseInt(st[1]);

    int[][] arr = new int[n][m];

    for (int i = 0; i < n; i++) {
      st = br.readLine().split(" ");
      for (int j = 0; j < m; j++) {
        arr[i][j] = Integer.parseInt(st[j]);
      }
    }

    System.out.println(orangesRotting(arr));

  }

  public static class Pair {
    int row;
    int col;
    int t;

    Pair(int row, int col) {
      this.row = row;
      this.col = col;
    }
    Pair(int row, int col,int t) {
      this.row = row;
      this.col = col;
      this.t = t;
    }

  }
    static int[] xdir = {-1,0,1,0};
    static int[] ydir = {0,1,0,-1};
  public static int orangesRotting(int[][] grid) {
    int fresh = 0;
    Queue<Pair> q = new LinkedList<>();
    for(int i=0; i < grid.length; i++) {
        for(int j=0; j < grid[0].length; j++) {
            if(grid[i][j] == 2) {
                q.add(new Pair(i,j,0));
            } else if(grid[i][j] == 1) {
                fresh++;
            }
        }
    }
    if(fresh == 0) return 0;
    int maxTime = 0;
    while(q.size() > 0) {
        int size = q.size();
        while(size-- > 0) {
            Pair rm = q.remove();
            maxTime = rm.t;
            for(int d=0; d < 4; d++){
                int r = rm.row + xdir[d];
                int c = rm.col + ydir[d];
                if(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1) {
                  fresh--;
                    grid[r][c] = 2;
                  q.add(new Pair(r,c,rm.t+1));
              }
            }    
        }
    }
    return fresh != 0 ? -1 : maxTime;
  }
}