package practice.string;

import java.util.Scanner;

public class _29MinNumberOfSwapsForBracketBalance2 {
    // O(n),O(1)
    public static void main (String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while(t != 0) {
		    int num = scn.nextInt();
		    String input = scn.next();
		    char[] s = input.toCharArray();
		    int count = 0;
		    int sum = 0;
		    int open = 0;
		    int close = 0;
		  int fault = 0;
		    for(int i=0;i<num;i++){
		        if(s[i] == ']'){
		            close++;
		            fault = close - open;
		        } else {
		            open++;
		            
		            if(fault > 0) {
		                sum += fault;
		                fault--;
		            }
		        }
		    }
		    System.out.println(sum);
		    t--;
		}
	}
}
