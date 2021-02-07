package practice.string;

import java.util.Scanner;

public class _7LongestPalindromeInString {
    // O(n^2),O(n^2)
    public static void main (String[] args) {
		Scanner scn = new Scanner(System.in);
		int T = scn.nextInt();
		while(T != 0) {
    		String s = scn.next();
    		System.out.println(findLongestPalindromeString(s));
    		T--;
		}
	}
	public static String findLongestPalindromeString(String s) {
	    boolean[][] dp = new boolean[s.length()][s.length()];
	    String ans = null;
	    for(int g=0;g < s.length();g++){
	        for(int i=0,j=g;j<s.length();i++,j++){
	            if(g == 0){
	                dp[i][j] = true;
	            } else if(g == 1) {
	                if(s.charAt(i) == s.charAt(j)) {
	                    dp[i][j] = true;
	                } else {
	                    dp[i][j] = false;
	                }
	            } else {
	                if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]){
	                    dp[i][j] = true;
	                } else {
	                    dp[i][j] = false;
	                }
	            }
	            
	            if(dp[i][j]) {
	                String str = s.substring(i,j+1);
	                if(ans == null){
	                    ans = str;
	                } else if(str.length() > ans.length()){
	                    ans = str;
	                }
	            }
	        }
	    }
	    return ans;
	}
}
