package dynamicprogramsLU;
import java.util.*;

public class _12CountDistinctSubsequence {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();

        int[] dp = new int[str.length()+1];
        dp[0] = 1;
        Map<Character,Integer> hm = new HashMap<>();
        for(int i=1;i<dp.length;i++){
            dp[i] = 2 * dp[i-1];
            char ch = str.charAt(i-1);
            if(hm.containsKey(ch)){
                int lo = hm.get(ch);
                dp[i] -= dp[lo-1];
            }
            hm.put(ch,i);
        }
        System.out.println(dp[str.length()] - 1);

    }

}
