package dynamicprogramsLU;
import java.io.*;
import java.util.*;

public class _19PrintAllZeroOneKnapsack {

    public static class Pair {
        int i;
        int j;
        String psf;
        Pair(int i,int j,String psf) {
            this.i = i;
            this.j = j;
            this.psf = psf;
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

        int[][] dp = new int[values.length+1][cap+1];

        for(int i=1;i < dp.length;i++){
            for(int j=1;j < dp[0].length;j++){
                dp[i][j] = dp[i-1][j];
                if(j >= wts[i-1]) {
                    int rm = dp[i-1][j-wts[i-1]] + values[i-1];
                    if(rm > dp[i-1][j]) {
                        dp[i][j] = rm;
                    }
                }
            }
        }
        System.out.println(dp[wts.length][cap]);
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(values.length,cap,""));
        while(q.size() > 0) {
            Pair rm = q.removeFirst();
            if(rm.i == 0 || rm.j == 0) {
                System.out.println(rm.psf);
            } else {
                int exc = dp[rm.i-1][rm.j];
                if(rm.j >= wts[rm.i-1]) {
                    int inc = dp[rm.i-1][rm.j-wts[rm.i-1]] + values[rm.i-1];

                    if(dp[rm.i][rm.j] == inc) {
                        q.add(new Pair(rm.i-1,rm.j-wts[rm.i-1],(rm.i-1)+" "+rm.psf));
                    }
                }

                if(dp[rm.i][rm.j] == exc){
                    q.add(new Pair(rm.i-1,rm.j,rm.psf));
                }
            }
        }
    }

}
