import java.io.*;
import java.util.*;

public class _20PrintAllResultsIn01Knapsack {
    public static class Pair{
        int i;
        int j;
        String psf;

        public Pair(String psf,int i, int j){
            this.i = i;
            this.j = j;
            this.psf = psf;
        }
    }

    private static void print01Knapsack(int[] value, int[] wts, int cap) {
        int n = value.length;
        int[][] dp = new int[n + 1][cap + 1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= cap; j++) {
                if(j < wts[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {    
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - wts[i - 1]] + value[i - 1]);
                }
            }
        }
        System.out.println(dp[n][cap]);

        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair("", n, cap));
        while(que.size() > 0) {
            Pair rem = que.remove();
            int i = rem.i;
            int j = rem.j;
            if(j == 0 || i == 0) {
                System.out.println(rem.psf);
                continue;
            }
            // yes call
            if(j - wts[i - 1] >= 0 && dp[i - 1][j - wts[i - 1]] == dp[i][j] - value[i - 1]) {
                que.add(new Pair((i - 1) + " "+ rem.psf, i - 1, j - wts[i - 1]));
            }
            // no call
            if(dp[i - 1][j] == dp[i][j]) {
                que.add(new Pair(rem.psf, i - 1, j));
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] values = new int[n];
        String str1 = br.readLine();
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(str1.split(" ")[i]);
        }

        int[] wts = new int[n];
        String str2 = br.readLine();
        for (int i = 0; i < n; i++) {
            wts[i] = Integer.parseInt(str2.split(" ")[i]);
        }

        int cap = Integer.parseInt(br.readLine());

        print01Knapsack(values,wts,cap);
        
    }
}


                        


                        


                        