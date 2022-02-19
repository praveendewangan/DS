import java.io.*;
import java.util.*;

public class _18PrintAllPathsWithMaxGold {


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
    private static int[] xarr = {-1, 0, 1};
    private static int[] yarr = {1, 1, 1};

    private static int maxInGoldmine(int x, int y, int[][] dp) {
        int max = Integer.MIN_VALUE;
        for(int d = 1; d <= 3; d++) {
            int r = x + xarr[d - 1];
            int c = y + yarr[d - 1];

            if(r >= 0 && r < dp.length && c >= 0 && c < dp[0].length) {
                max = Math.max(max, dp[r][c]);
            }
        }
        return max;
    }

    private static void printPathGoldmine(int[][] mine) {
        int n = mine.length;
        int m = mine[0].length;

        int[][] dp = new int[n][m];
        int max = Integer.MIN_VALUE;
        for(int c = m - 1; c >= 0; c--) {
            for(int r = 0; r < n; r++) {
                if(c == m - 1) {
                    dp[r][c] = mine[r][c];
                } else if(r == 0) { // compare D2 and D3
                    dp[r][c] = Math.max(dp[r][c + 1], dp[r + 1][c + 1]) + mine[r][c];
                } else if(r == n - 1) { // compare D1 and D2
                    dp[r][c] = Math.max(dp[r - 1][c + 1], dp[r][c + 1]) + mine[r][c];
                } else { // compare D1, D2, and D3
                    dp[r][c] = Math.max(dp[r - 1][c + 1], Math.max(dp[r][c + 1], dp[r + 1][c + 1])) + mine[r][c];
                }
                max = Math.max(max, dp[r][c]);
            }
        }
        System.out.println(max);

        Queue<Pair> que = new LinkedList<>();
        for(int r = 0; r < n; r++) {
            if(dp[r][0] == max) {
                que.add(new Pair(""  + r + " ", r, 0));
            }
        }

        while(que.size() > 0) {
            Pair rem = que.remove();
            int i = rem.i;
            int j = rem.j;

            if(j == m - 1) {
                System.out.println(rem.psf);
                continue;
            } else {
                int maxInDiagonal = maxInGoldmine(i, j, dp);
                for(int d = 1; d <= 3; d++) {
                    int r = i + xarr[d - 1];
                    int c = j + yarr[d - 1];
                    if(r >= 0 && r < dp.length && c >= 0 && 
                        c < dp[0].length && dp[r][c] == maxInDiagonal) {
                        que.add(new Pair(rem.psf + "d" + d + " ", r, c));
                    }
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
        printPathGoldmine(arr);
      //write your code here
   }


}