import java.io.*;
import java.util.*;

public class _31LexicographicalNumber {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		for(int i = 1; i < 10; i++) {
		    solve(i,n);
		}
	}
	
	private static void solve(int val,int n) {
	    if(val > n) {
	        return;
	    }
	    
	    System.out.println(val);
	    for(int i=0; i < 10; i++) {
	        solve(10*val+i,n);
	    }
	}
	
}