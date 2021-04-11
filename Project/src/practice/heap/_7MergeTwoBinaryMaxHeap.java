package practice.heap;

import java.util.Scanner;

public class _7MergeTwoBinaryMaxHeap {
    public static void main (String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while(t > 0) {
		    int n = scn.nextInt();
		    int m = scn.nextInt();
		    int[] a = new int[n+m];
		    for(int i=0;i < n+m;i++){
		        a[i] = scn.nextInt();
		    }
		    n += m;
		    mergeHeap(a,n);
		    for(int num : a){
		        System.out.print(num + " ");
		    }
		        System.out.println();
		    t--;
		}
	}
	public static void mergeHeap(int[] a,int n) {
	    for(int i=n/2 - 1;i >= 0;i--){
	        maxHeap(a,n,i);
	    }
	}
	private static void maxHeap(int[] a,int n,int pi) {
	    int max = pi;
	    int li = 2*pi + 1;
	    int ri = 2*pi + 2;
	    if(li < n && a[li] > a[pi]){
	        max = li;
	    }
	    if(ri < n && a[ri] > a[max]){
	        max = ri;
	    }
	    if(max != pi) {
	        int t = a[max];
	        a[max] = a[pi];
	        a[pi] = t;
	        maxHeap(a,n,max);
	    }
	}
}
