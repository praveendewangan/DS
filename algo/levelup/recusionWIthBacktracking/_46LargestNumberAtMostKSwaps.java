import java.io.*;
import java.util.*;

public class _46LargestNumberAtMostKSwaps {

	static String max;
	public static void findMaximum(String str, int k) {
        if(Integer.parseInt(max) < Integer.parseInt(str)){
	        max = str;
        }
	   // if(k == 0) {
	   //     return;
	   // }
		
		for(int i = 0; i < str.length()-1; i++) {
		    for(int j = i+1; j < str.length(); j++){
		        if(str.charAt(j) > str.charAt(i) && k > 0) {
		            String left = str.substring(0,i);
		            char ch1 = str.charAt(i);
		            String mid = str.substring(i+1,j);
		            char ch2 = str.charAt(j);
		            String right = str.substring(j+1);
		            str = left + ch2 + mid + ch1 + right;
		            findMaximum(str,k-1);
		            str = left + ch1 + mid + ch2 + right;
		        }
		    }
		}
	}
	
	private static boolean valid(String str,int i,int j) {
	    int n1 = (int)(str.charAt(i) - 'a');
	    int n2 = (int)(str.charAt(j) - 'a');
	    return n1 < n2;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		int k = scn.nextInt();
		 max = str;
		findMaximum(str, k);
		System.out.println(max);
	}

}