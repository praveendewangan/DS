package dynamicprogramsLU;
import java.io.*;
import java.util.*;

public class _16PrintAllPathsWithMinCost {


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

        int dp[][] = new int[arr.length][arr[0].length];
        for(int i = arr.length-1;i >= 0;i--) {
            for(int j = arr[0].length-1;j >= 0;j--) {
                if(i == dp.length-1 && j == dp[0].length-1){
                    dp[i][j] = arr[i][j];
                } else if(i == dp.length - 1) {
                    dp[i][j] = arr[i][j] + dp[i][j+1];
                } else if(j == dp[0].length - 1) {
                    dp[i][j] = arr[i][j] + dp[i+1][j];
                } else {
                    dp[i][j] = arr[i][j] + Math.min(dp[i][j+1],dp[i+1][j]);
                }
            }
        }
        System.out.println(dp[0][0]);
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair("",0,0));
        while(q.size() > 0){
            Pair rm = q.removeFirst();

            if(rm.i == dp.length-1 && rm.j == dp[0].length-1){
                System.out.println(rm.psf);
            } else if(rm.i == dp.length - 1) {
                q.add(new Pair(rm.psf+"H",rm.i,rm.j+1));
            } else if(rm.j == dp[0].length - 1) {
                q.add(new Pair(rm.psf+"V",rm.i+1,rm.j));
            } else {
                if(dp[rm.i][rm.j+1] < dp[rm.i+1][rm.j]) {
                    q.add(new Pair(rm.psf+"H",rm.i,rm.j+1));
                } else if(dp[rm.i][rm.j+1] > dp[rm.i+1][rm.j]) {
                    q.add(new Pair(rm.psf+"V",rm.i+1,rm.j));
                } else {
                    q.add(new Pair(rm.psf+"V",rm.i+1,rm.j));
                    q.add(new Pair(rm.psf+"H",rm.i,rm.j+1));
                }
            }
        }
    }


}
