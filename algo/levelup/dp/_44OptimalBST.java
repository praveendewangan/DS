import java.io.*;
import java.util.*;

public class _44OptimalBST {
  
  private static void optimalbst(int[] keys, int[] frequency, int n) {
        int[] pis = new int[n];
        pis[0] = frequency[0];
        for(int i=1;i<n;i++) {
            pis[i] = pis[i-1]+frequency[i];
        }
        int[][] dp = new int[n][n];
        for(int g=0; g < n; g++) {
            for(int i=0,j=g; j<n;i++,j++) {
                if(g == 0) {
                    dp[i][j] = frequency[i];
                } else if(g == 1) {
                    int f1 = frequency[i];
                    int f2 = frequency[j];
                    dp[i][j] = Math.min(f1+2*f2,2*f1+f2);
                } else {
                    int min = Integer.MAX_VALUE;
                    int fs = pis[j] - (i==0? 0: pis[i-1]);
                    for(int k=i; k<=j; k++) {
                        int left = k==i?0 : dp[i][k-1];
                        int right = k==j?0 : dp[k+1][j];
                        min = Math.min(min,left+right+fs);
                    }
                    dp[i][j] = min;
                }
            }
        }
        System.out.println(dp[0][n-1]);
    
	}

    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
    	int[] keys = new int[n];
    	int[] frequency = new int[n];
        for(int i= 0 ;i < n ; i++) {
    		keys[i] = scn.nextInt();
    	}
    	for(int i = 0 ; i < n; i++){
          frequency[i] = scn.nextInt();
        }
    	optimalbst(keys,frequency,n);
	}

}