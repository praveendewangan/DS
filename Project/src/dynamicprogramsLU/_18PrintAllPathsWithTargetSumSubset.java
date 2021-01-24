package dynamicprogramsLU;
import java.io.*;
import java.util.*;

public class _18PrintAllPathsWithTargetSumSubset {



    public static class Pair {
        int i;
        int j;
        String psf;

        public Pair(int i, int j, String psf) {
            this.i = i;
            this.j = j;
            this.psf = psf;
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

        boolean[][] dp = new boolean[arr.length+1][tar+1];

        for(int i=0;i < dp.length;i++){
            for(int j=0;j < dp[0].length;j++){
                if(j == 0){
                    dp[i][j] = true;
                } else if(i == 0){
                    dp[i][j] = false;
                } else {
                    dp[i][j] = dp[i-1][j];
                    if(dp[i-1][j]) {
                        dp[i][j] = true;
                    } else if(j >= arr[i-1]){
                        if(dp[i-1][j-arr[i-1]]){
                            dp[i][j] = true;
                        }
                    }
                }
            }
        }
        System.out.println(dp[arr.length][tar]);
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(n,tar,""));

        while(q.size() > 0) {
            Pair rm = q.removeFirst();
            if(rm.i == 0 || rm.j == 0) {
                System.out.println(rm.psf);
            } else {
                boolean exc = dp[rm.i-1][rm.j];
                if(exc){
                    q.add(new Pair(rm.i-1,rm.j,rm.psf));
                }
                if(rm.j >= arr[rm.i-1]) {
                    boolean inc = dp[rm.i-1][rm.j-arr[rm.i-1]];
                    if(inc) {
                        q.add(new Pair(rm.i-1,rm.j-arr[rm.i-1],(rm.i-1)+" "+rm.psf));
                    }
                }
            }
        }

    }

}
