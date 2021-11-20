import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _7AsFarFromLandAsPossibleLC1162 {

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

    System.out.println(maxDistance(arr));

  }
  private static class Pair {
    int x;
    int y;

    Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  private static int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

  public static int maxDistance(int[][] grid) {
    Queue<Pair> q = new LinkedList<>();
    // 1. Add all ones
    for(int i=0; i<grid.length; i++) {
        for(int j=0; j<grid[0].length;j++) {
            if(grid[i][j] == 1) {
                grid[i][j] = -1;
                q.add(new Pair(i,j));
            }
        }
    }
    int level = -1;
    // 2. BFS for 0
    while(q.size() > 0) {
        level++;
        int size = q.size();
        while(size-- > 0) {
            Pair rm = q.remove();
            for(int d=0;d<4;d++){
                int r = rm.x+dirs[d][0];
                int c = rm.y+dirs[d][1];
                if(r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == 0 ) {
                        q.add(new Pair(r,c));
                        grid[r][c] = -1;
                    }
            }
        }
    }
    return level == 0 ? -1 : level;
  }
}
