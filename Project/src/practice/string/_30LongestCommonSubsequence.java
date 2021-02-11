package practice.string;

public class _30LongestCommonSubsequence {
    // O(n*m),O(n*m+1)
    
    static int lcs(int p, int q, String s1, String s2){
        int dp[][] = new int[p+1][q+1];
        
        for(int i=dp.length-2;i>=0;i--){
            for(int j=dp[0].length-2;j>=0;j--) {
                if(s1.charAt(i) == s2.charAt(j)){
                    dp[i][j] = 1 + dp[i+1][j+1];
                } else {
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }
        return dp[0][0];
    }
}
