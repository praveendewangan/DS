package practice.searchingAndSorting;

import java.util.Scanner;

public class _10FindPairWithDifference {
    // O(n^n),O(1)
    public static void main (String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while(t != 0) {
		    int len = Integer.parseInt(scn.next().trim());
		    int n = Integer.parseInt(scn.next().trim());
		    int[] inputs = new int[len];
		    for(int i=0;i<len;i++){
		        inputs[i] = Integer.parseInt(scn.next().trim());
		    }
		    System.out.println(findDiffEle(inputs,n));
		    t--;
		}
	}
	private static int findDiffEle(int[] a,int n) {
	    for(int i=0;i<a.length-1;i++){
	        for(int j=i+1;j<a.length;j++){
	            if(Math.abs(a[i]-a[j]) == n){
	                return 1;
	            }
	        }
	    }
	    return -1;
	}
}
