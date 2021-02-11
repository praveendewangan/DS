package practice.string;

import java.util.Scanner;
import java.util.Stack;

public class _20CountTheReversal {
    public static void main (String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while(t != 0) {
		    String input = scn.next();
		    System.out.println(find(input));
		    t--;
		}
	}
	private static int find(String input) {
	    int len = input.length();
	    if((len & 1) == 1){
	        return -1;
	    }
	    int c1 = 0;
	    int c = 0;
	    Stack<Character> st = new Stack<>();
	    for(int i=0;i<len;i++){
	        char ch = input.charAt(i);
	        if(ch == '{'){
	            st.push(ch);
	            c1++;
	        } else if(ch == '}' && st.size() > 0 && st.peek() == '{'){
                st.pop();
                c1--;
	        } else {
	            c++;
	        }
        }
        /* rest string to be balance = } {{{
        *  
        */
	    if((c1 & 1) == 1) {
	        c1 = (c1+1)/2;
	    } else {
	        c1 = c1 / 2;
	    }
	    
	    if((c & 1) == 1) {
	        c = (c+1)/2;
	    } else {
	        c = c / 2;
	    }
	    return c+c1;
	}
}
