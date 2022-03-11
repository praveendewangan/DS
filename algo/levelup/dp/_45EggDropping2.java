import java.io.*;
import java.util.*;

public class _45EggDropping2 {

	public static int eggDrop(int e, int f){
		int[][] dp = new int[e+1][f+1];
		for(int i = 1; i <= e; i++) {
		    for(int j=1; j <= f; j++) {
		        if(j == 1) {
		            dp[i][j] = 1;
		        } else if(i == 1) {
		            dp[i][j] = j;
		        } else {
                    // use binary search
		            int min = Math.max(dp[i-1][0],dp[i][j-1]);
                    int lo = 1;
                    int hi = j;
                    while(lo <= hi) {
                        int m = (lo + hi) / 2;
                        int left = dp[i-1][m-1];
                        int right = dp[i][j-m];
                        int max = Math.max(left,right);
                        min = Math.min(min,max);
                        if(left < right) {
                            lo = m+1;
                        } else {
                            hi = m-1;
                        }
                        
                    }
		            dp[i][j] = min+1;
		        }
		    }
		}

		return dp[e][f];
	} 

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		//n -> number of eggs and k -> number of floors
		int n = scn.nextInt();
		int k = scn.nextInt();
		System.out.println(eggDrop(n,k));
	}
	
}