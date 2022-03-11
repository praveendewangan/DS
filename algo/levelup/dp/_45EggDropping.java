import java.io.*;
import java.util.*;

public class _45EggDropping {

	public static int eggDrop(int e, int f){
		int[][] dp = new int[e+1][f+1];
		for(int i = 1; i <= e; i++) {
		    for(int j=1; j <= f; j++) {
		        if(j == 1) {
		            dp[i][j] = 1;
		        } else if(i == 1) {
		            dp[i][j] = j;
		        } else {
		            int min = Integer.MAX_VALUE;
		            for(int a = 0,b=j-1; a < j; a++,b--) {
		                int first = dp[i-1][a]; // egg break
		                int last = dp[i][b]; // egg survive
		                min = Math.min(min,Math.max(first,last));
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