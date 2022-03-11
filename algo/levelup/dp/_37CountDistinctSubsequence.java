import java.util.*;

public class _37CountDistinctSubsequence{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        
        System.out.println(countDistinctSubseq(str));

    }
    
        // count distinct subseq.
    private static long countDistinctSubseq(String str) {
        int n = str.length();
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 2;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put(str.charAt(0), 0);
        for(int i = 2; i <= n; i++) {
            char ch = str.charAt(i - 1);
            long prevVal = map.containsKey(ch) == true ? dp[map.get(ch)] : 0;
            dp[i] = 2 * dp[i - 1] - prevVal;
            map.put(ch,i-1);
        }
        // subtract 1 for all no's
        return dp[n] - 1;
    }
}