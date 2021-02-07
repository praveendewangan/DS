package practice.string;

public class _13EditDistance {
    public static void main(String[] args) {
        String s = "geek";
        String t ="gesek";
        System.out.println(editDistance(s,t));
    }
    public static int editDistance(String s, String t)
    {
        int[][] dp = new int[s.length()+1][t.length()+1];
        for(int i = 0;i<=s.length();i++){
            for(int j=0;j<=t.length();j++){
                if(i == 0){
                    dp[i][j] = j;
                } else if(j == 0){
                    dp[i][j] = i;
                } else if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}
