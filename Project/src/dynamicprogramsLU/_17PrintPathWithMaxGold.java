package dynamicprogramsLU;
import java.io.*;
import java.util.*;

public class _17PrintPathWithMaxGold {


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

        int[][] dp = new int[arr.length][arr[0].length];

        for (int j = arr[0].length - 1; j >= 0; j--) {
            for (int i = arr.length - 1; i >= 0; i--) {
                if (j == arr[0].length - 1) {
                    dp[i][j] = arr[i][j];
                } else if (i == 0) {
                    dp[i][j] = arr[i][j] + Math.max(dp[i + 1][j + 1], dp[i][j + 1]);
                } else if (i == arr.length - 1) {
                    dp[i][j] = arr[i][j] + Math.max(dp[i - 1][j + 1], dp[i][j + 1]);
                } else {
                    dp[i][j] = arr[i][j] + Math.max(dp[i + 1][j + 1], Math.max(dp[i - 1][j + 1], dp[i][j + 1]));
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            if (max < dp[i][0]) {
                max = dp[i][0];
            }
        }
        System.out.println(max);
        ArrayDeque < Pair > q = new ArrayDeque < > ();

        for (int i = 0; i < arr.length; i++) {
            if (max == dp[i][0]) {
                q.add(new Pair(i + "", i, 0));
            }
        }

        while (q.size() > 0) {
            Pair rm = q.removeFirst();
            if (rm.j == arr[0].length - 1) {
                System.out.println(rm.psf);
            } else if (rm.i == 0) {
                int g = Math.max(dp[rm.i][rm.j + 1], dp[rm.i + 1][rm.j + 1]);
                if (g == dp[rm.i][rm.j + 1]) {
                    q.add(new Pair(rm.psf + " d2", rm.i, rm.j + 1));
                }
                if (g == dp[rm.i + 1][rm.j + 1]) {
                    q.add(new Pair(rm.psf + " d3", rm.i + 1, rm.j + 1));
                }
            } else if (rm.i == arr.length - 1) {
                int g = Math.max(dp[rm.i][rm.j + 1], dp[rm.i - 1][rm.j + 1]);
                if (g == dp[rm.i][rm.j + 1]) {
                    q.add(new Pair(rm.psf + " d2", rm.i, rm.j + 1));
                }
                if (g == dp[rm.i - 1][rm.j + 1]) {
                    q.add(new Pair(rm.psf + " d1", rm.i - 1, rm.j + 1));
                }
            } else {
                int g = Math.max(dp[rm.i][rm.j + 1], Math.max(dp[rm.i + 1][rm.j + 1], dp[rm.i - 1][rm.j + 1]));
                if (g == dp[rm.i][rm.j + 1]) {
                    q.add(new Pair(rm.psf + " d2", rm.i, rm.j + 1));
                }
                if (g == dp[rm.i - 1][rm.j + 1]) {
                    q.add(new Pair(rm.psf + " d1", rm.i - 1, rm.j + 1));
                }
                if (g == dp[rm.i + 1][rm.j + 1]) {
                    q.add(new Pair(rm.psf + " d3", rm.i + 1, rm.j + 1));
                }
            }
        }
    }



}
