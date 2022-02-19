import java.io.*;
import java.util.*;

public class _19PrintAllPathsWithTargetSumSubsets {

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
    private static void printPathtargetSumSubset(int[] arr, int tar) {
        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][tar + 1];
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= tar; j++) {
                if(j == 0) {
                    dp[i][j] = true;
                } else if(i == 0) {
                    dp[i][j] = false;
                } else {
                    if(j < arr[i - 1]) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                    }
                }
            }
        }
        System.out.println(dp[n][tar]);
        Queue<Pair> que = new LinkedList<>();
        if(dp[n][tar] == true) {
            que.add(new Pair("", n, tar));
        }
        while(que.size() > 0) {
            Pair rem = que.remove();
            int i = rem.i;
            int j = rem.j;
            if(j == 0) {
                System.out.println(rem.psf);
                continue;
            } else if(i == 0) {
                continue;
            }
            // yes call
            if(j - arr[i - 1] >= 0 && dp[i - 1][j - arr[i - 1]] == true) {
                que.add(new Pair((i - 1) + " " +rem.psf, i - 1, j - arr[i - 1]));
            }
            // no call
            if(dp[i - 1][j] == true) {
                que.add(new Pair(rem.psf, i - 1, j));
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int tar = Integer.parseInt(br.readLine());

        printPathtargetSumSubset(arr,tar);

    }
}


                        


                        