package practice.string;

public class _38WildCardEntryinString {
    public static void main (String[] args) {
	    Scanner scn =  new Scanner(System.in);
	    int t = scn.nextInt();
	    while(t != 0 ){
	        String pat = scn.next();
	        String str = scn.next();
	    	boolean[][] dp = new boolean[pat.length()+1][str.length()+1];
	    	for(int i=dp.length-1;i>=0;i--){
	    	    for(int j=dp[0].length-1;j>=0;j--){
	    	        if(i == dp.length-1 && j==dp[0].length-1) {
	    	            dp[i][j] = true;
	    	        } else if(i == dp.length-1) {
	    	            dp[i][j] = false;
	    	        } else if(j == dp[0].length-1) {
	    	            if(pat.charAt(i) == '*'){
	    	                dp[i][j] = dp[i+1][j];
	    	            } else {
    	    	            dp[i][j] = false;
	    	            }
	    	        } else {
	    	            if(pat.charAt(i) == '?'){
	    	                dp[i][j] = dp[i+1][j+1];
	    	            } else if(pat.charAt(i) == '*'){
	    	                dp[i][j] = dp[i+1][j] || dp[i][j+1];
	    	            } else if(pat.charAt(i) != str.charAt(j)) {
	    	                dp[i][j] = false;
	    	            } else {
	    	                dp[i][j] = dp[i+1][j+1];
	    	            }
	    	        }
	    	    }
	    	}
	    	if(dp[0][0]){
	    	    System.out.println("Yes");
	    	} else {
	    	    System.out.println("No");
	    	}
	        t--;
	    }
	}
}
