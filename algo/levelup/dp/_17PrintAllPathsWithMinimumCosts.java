import java.io.*;
import java.util.*;

public class _17PrintAllPathsWithMinimumCosts {

    private static class Pair {
        String psf;
        int i;
        int j;
        
        public Pair(String psf, int i, int j) {
            this.psf = psf;
            this.i = i;
            this.j = j;
        }
    }
    
    private static void printAllMinCost(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        
        for(int i = n - 1; i >= 0; i--) {
            for(int j = m - 1; j >= 0; j--) {
                if(i == n - 1 && j == m - 1) {
                    dp[i][j] = grid[i][j];
                } else if(i == n -1) {
                    dp[i][j] = grid[i][j] + dp[i][j + 1];
                } else if(j == m - 1) {
                    dp[i][j] = grid[i][j] + dp[i + 1][j];
                } else {
                    dp[i][j] = grid[i][j] + Math.min(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        System.out.println(dp[0][0]);

        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair("", 0, 0));
        while(que.size() > 0) {
            Pair rem = que.remove();
            int i = rem.i;
            int j = rem.j;

            if(i == n - 1 && j == m - 1) {
                System.out.println(rem.psf);
                continue;
            } else if(i == n - 1) {
                que.add(new Pair(rem.psf + "H", i, j + 1));
            } else if(j == m - 1) {
                que.add(new Pair(rem.psf + "V", i + 1, j));
            } else {
                if(dp[i + 1][j] == dp[i][j + 1]) {
                    // add V
                    que.add(new Pair(rem.psf + "V", i + 1, j));
                    // add H
                    que.add(new Pair(rem.psf + "H", i, j + 1));
                } else if(dp[i + 1][j] < dp[i][ j + 1]) {
                    que.add(new Pair(rem.psf + "V", i + 1, j));
                } else {
                    que.add(new Pair(rem.psf + "H", i, j + 1));
                }
            }
        }
    } 

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int m = Integer.parseInt(br.readLine());
      int[][] arr = new int[n][m];

      for (int i = 0; i < n; i++) {
         String str = br.readLine();
         for (int j = 0; j < m; j++) {
            arr[i][j] = Integer.parseInt(str.split(" ")[j]);
         }
      }

      printAllMinCost(arr);
      
   }

}