package practice.string;

import java.io.*;

public class _12WordWrap {
    
    // O(n^2)

	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 		System.out.println(args.length);
// 		System.exit(0);
		// int T = Integer.parseInt(br.readLine().trim());
		int T = 1;
		while(T != 0) {
		    // int n = Integer.parseInt(br.readLine().trim());
		    int n = 4;
		    String[] s = br.readLine().trim().split(" ");
		    // int[] a = new int[n+1];
		    int[] a = {3,2,2,5};
		    // for(int i=1;i<=n;i++){
		    //     a[i] = Integer.parseInt(s[i-1]);
		    // }
		    // int m = Integer.parseInt(br.readLine().trim());
		    int m = 6;
            solution(a,n,m);
            T--;
		}
	}
	
	private static void solution(int[] a,int n,int m) {
	    int[][] spaces = new int[n+1][n+1];
	    int[][] ls = new int[n+1][n+1];
	    int[] c = new int[n+1];
	    int[] p = new int[n+1];
	    for(int i=1;i<=n;i++) {
	        spaces[i][i] = m - a[i];
	        for(int j=i+1;j<=n;j++) {
	            spaces[i][j] = spaces[i][j-1] - a[j] - 1;
	        }
	    }
	    
	    for(int i=1;i<=n;i++){
	        for(int j=1;j<=n;j++) {
	            if(spaces[i][j] < 0) {
	                ls[i][j] = Integer.MAX_VALUE;
	            } else if(j == n && spaces[i][j] >= 0) {
	                ls[i][j] = 0;
	            } else {
	                ls[i][j] = spaces[i][j] * spaces[i][j];
	            }
	        }
	    } 
	    for(int i=1;i<=n;i++){
	        c[i] = Integer.MAX_VALUE;
	        for(int j=1;j<=i;j++) {
	            if(c[j-1] != Integer.MAX_VALUE && ls[j][i] != Integer.MAX_VALUE
	            && c[j-1]+ls[j][i] < c[i]) {
	                c[i] = c[j-1]+ls[j][i];
	                p[i] = j;
	            }
	        }
	    }
	    print(p,n);
	    System.out.println();
	}
	private static void print(int[] p,int n){
	    if(p[n] == 1) {
	        System.out.print(p[n] + " " + n + " ");
	    } else {
	        print(p,p[n]-1);
	        System.out.print(p[n] + " " + n + " ");
	    }
	}
}
