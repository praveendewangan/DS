import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class _6ZeroOneMatrixLC542 {
  private static class Pair {
    int x;
    int y;

    Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  private static int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

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

    int[][] ans = updateMatrix(arr);

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        System.out.print(ans[i][j] + " ");
      }
      System.out.println();
    }

  }

  public static int[][] updateMatrix(int[][] matrix) {
        Queue<Pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[matrix.length][matrix[0].length];
        // 1. travel and fill 0 in queue
        for(int i=0; i < matrix.length; i++) {
            for(int j=0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    vis[i][j] = true;
                    q.add(new Pair(i,j));
                }
            }
        }
        
        // 2. Run BFS and mark level in given matrix and use a visited matrix
        int level = -1;
        while(q.size() > 0) {
            level++;
            int size = q.size();
            while(size-- > 0) {
                Pair rm = q.remove();
                matrix[rm.x][rm.y] = level;
                
                for(int d=0; d < 4; d++) {
                    int r = rm.x + dirs[d][0];
                    int c = rm.y + dirs[d][1];
                    if(r >= 0 && c >= 0 && r < matrix.length && c < matrix[0].length && matrix[r][c] == 1 && !vis[r][c]) {
                        q.add(new Pair(r,c));
                        vis[r][c] = true;
                    }
                }
            }
        }
        return matrix;
  }
  
}