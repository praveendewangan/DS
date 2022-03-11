import java.io.*;
import java.util.*;

public class _38CountOfDistinctPalindromicSubsequences {

	public static int solution(String str) {
		int n = str.length();
        int[] next = new int[n];
        int[] prev = new int[n];

        HashMap<Character, Integer> map = new HashMap<>();
        // set next,
        for(int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            if(map.containsKey(ch) == true) {
                prev[i] = map.get(ch);
            } else {
                prev[i] = i;
            }
            map.put(ch, i);
        }

        map.clear();
        for(int i = n - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            if(map.containsKey(ch) == true) {
                next[i] = map.get(ch);
            } else {
                next[i] = i;
            }
            map.put(ch, i);
        }
        int[][] dp = new int[n][n];
        for(int gap = 0; gap < n; gap++) {
            for(int i = 0, j = gap; j < n; i++, j++) {
                if(gap == 0) {
                    dp[i][j] = 1;
                } else if(gap == 1) {
                    dp[i][j] = 2;
                } else {
                    if(str.charAt(i) == str.charAt(j)) {
                        int nextCharIndx = next[i];
                        int prevCharIndx = prev[j];
                        if(nextCharIndx == j && prevCharIndx == i) {
                            // no ch available in middle part
                            dp[i][j] = 2 * dp[i + 1][j - 1] + 2;
                        } else if(nextCharIndx == prevCharIndx) {
                            // single ch available in middle part
                            dp[i][j] = 2 * dp[i + 1][j - 1] + 1;
                        } else {
                            // more than one ch available
                            dp[i][j] = 2 * dp[i + 1][j - 1] - dp[nextCharIndx + 1][prevCharIndx - 1];
                        }
                    } else {
                        dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1];
                    }
                }
            }
        }
        return dp[0][n - 1];
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}

}