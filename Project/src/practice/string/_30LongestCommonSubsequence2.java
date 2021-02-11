package practice.string;

public class _30LongestCommonSubsequence2 {
    // O(n*m),O(2*m)
    static int lcs(int p, int q, String s1, String s2){
        int dp[][] = new int[2][s2.length()+1];
        int idx = 0;
        for(int i=1;i<=p;i++){
            idx = i&1;
            for(int j=1;j<=q;j++) {
                if(i == 0 || j == 0){
                    dp[idx][j] = 0;
                } else if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[idx][j] = 1 + dp[1-idx][j-1];
                } else {
                    dp[idx][j] = Math.max(dp[1-idx][j],dp[idx][j-1]);
                }
            }
        }
        return dp[idx][q];
    }
}
