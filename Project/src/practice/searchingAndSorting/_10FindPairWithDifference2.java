package practice.searchingAndSorting;

import java.util.Arrays;
import java.util.Scanner;

public class _10FindPairWithDifference2 {
    // O(nLogn),O(1)
    public static void main (String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while(t != 0) {
		  //  String para = scn.next();
		  //  System.out.println(para);
		  //  System.exit(0);
		  //  String[] con = scn.next().split(" ");
		    int len = Integer.parseInt(scn.next().trim());
		    int n = Integer.parseInt(scn.next().trim());
		  //  String[] sinputs = scn.next().split(" ");
		    int[] inputs = new int[len];
		    for(int i=0;i<len;i++){
		        inputs[i] = Integer.parseInt(scn.next().trim());
		    }
		    System.out.println(findDiffEle(inputs,n));
		    t--;
		}
	}
	private static int findDiffEle(int[] a,int n) {
	    Arrays.sort(a);
	    int i = 0;
	    int j = 1;
	    while(i < a.length && j < a.length) {
	        if(i != j && a[j] - a[i] == n){
	            return 1;
	        } else if(a[j] - a[i] < n) {
	            j++;
	        } else {
	            i++;
	        }
	    }
	    return -1;
	}
}
