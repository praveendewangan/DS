package practice.string;

import java.util.Scanner;

public class _27MinNumberOfFlips {
    /* 
        input = 1111;
        res = 0101 or 1010;
        O(n),O(1)    
    */
	public static void main (String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while(t != 0) {
		    String input = scn.next();
		    StringBuilder sb = new StringBuilder(input);
		    
		    int c1 = 0;
		    int c2 = 0;
		    for(int i=0;i<input.length();i++){
		        if((i%2 == 1) && input.charAt(i) == '0') c1++;
		        if((i%2 == 0) && input.charAt(i) == '1') c1++;
		        if((i%2 == 1) && input.charAt(i) == '1') c2++;
		        if((i%2 == 0) && input.charAt(i) == '0') c2++;
		    }
		    System.out.println(Math.min(c1,c2));
		    t--;
		}
	}   
}
