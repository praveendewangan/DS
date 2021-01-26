package practice.arrays;

import java.util.*;

public class _13KadansAlgo {
	public static void main(String[] args) {
		int n = 5;
		int a[] = {1,2,3,-2,5};
		int max = Integer.MIN_VALUE;
		int val = 0;
		for(int i=0 ; i < n ; i++){
			val = val + a[i];
			if(val < a[i]){
				val = a[i];
			}
			if(max < val){
				max = val;
			}
		}
		System.out.println(max);
	}
}