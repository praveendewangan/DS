import java.io.*;
import java.util.*;

public class _40AllPalindromicPartition {

	public static void solution(String str, String asf) {
	    if(str.equals("")) {
	        System.out.println(asf);
	        return;
	    }
        for(int i=0; i < str.length(); i++) {
            String option = str.substring(0,i+1);
            String roq = str.substring(i+1);
            if(isPalindromic(option)) {
                solution(roq,asf+"("+option+") ");
            }
        }
	}
	
	private static boolean isPalindromic(String str) {
	    int i = 0;
	    int j = str.length()-1;
	    while(i < j) {
	        if(str.charAt(i) != str.charAt(j)) {
	            return false;
	        }
	        i++;
	        j--;
	    }
	    return true;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		solution(str, "");
	}

}