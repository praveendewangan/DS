
import java.io.*;
import java.util.*;

public class _32Goldmine2 {
	static int max = 0;
	static int[] xdir = {-1,0,1,0};
	static int[] ydir = {0,-1,0,1};
	public static void getMaxGold(int[][] arr){
	    int n = arr.length;
	    int m = arr[0].length;
	   // boolean[][] v = new boolean[n][m];
		for(int i = 0; i < arr.length; i++){
		    for(int j = 0; j < arr[0].length; j++) {
		        if(arr[i][j] > 0) {
		            int res = solve(arr,i,j);
		            max = Math.max(res,max);
		        }
		    }
		}
		
	}
	
	private static int solve(int[][] a,int i,int j) {
	    int res = a[i][j];
	    a[i][j] = -1;
	    for(int d = 0; d < xdir.length; d++){
	        int r = xdir[d] + i;
	        int c = ydir[d] + j;
	        if(r < a.length && c < a[0].length && r >= 0 && c >= 0 && a[r][c] > 0) {
	            res += solve(a,r,c);
	        }
	    }
	    return res;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		int[][] arr = new int[m][n];
		for(int i = 0; i < arr.length; i++){
			for(int j = 0 ; j  < arr[0].length; j++){
				arr[i][j] = scn.nextInt();
			}
		}
		getMaxGold(arr);
		System.out.println(max);
	}
		
}