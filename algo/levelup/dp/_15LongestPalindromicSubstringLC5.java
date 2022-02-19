public class _15LongestPalindromicSubstringLC5 {
    public String longestPalindrome(String s) {
        // return longestPalindromedp(s);
        return longestPalindromepointer(s);
    }
    // using dp
    public String longestPalindromedp(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int x = 0;
        int y = 0;
        for(int gap = 0; gap < n; gap++) {
            for(int i = 0, j = gap; j < n; i++, j++) {
                if(gap == 0) {
                    dp[i][j] = true;
                } else if(gap == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                }
                if(dp[i][j] == true) {
                    x = i;
                    y = j;
                }
            }
        }
        return s.substring(x, y + 1);
    }
//     using pointers
    
    public String longestPalindromepointer(String s) {
        String ans = null;
        int n = s.length();
        int start = 0;
        int end = 0;
        for(int i = 1; i < n; i++){
            int l = i-1;
            int h = i;
            
            while(l >= 0 && h < n && s.charAt(l) == s.charAt(h)) {
                if(h-l+1 > end-start+1) {
                    start = l;
                    end = h;
                }
                l--;
                h++;
            }
            
            l = i-1;
            h = i+1;
            
            while(l >= 0 && h < n && s.charAt(l) == s.charAt(h)) {
                if(h-l+1 > end-start+1) {
                    start = l;
                    end = h;
                }
                l--;
                h++;
            }
        }
        return s.substring(start,end+1);
    }
    public String longestPalindrome1(String s) {
        String ans = "";
        boolean isEven = s.length() % 2 == 0;
        int start = 0, end = 1;
        for(int i=1; i < s.length(); i++) {
            int l,h;
            l = i-1;
            h = i;
            
            while(l >= 0 && h < s.length() && s.charAt(l) == s.charAt(h)) {
                if(h-l+1 > end) {
                    start = l;
                    end = h-l+1;
                }
                l--;
                h++;
            }
            
            l = i-1;
            h = i + 1;
            while(l >= 0 && h < s.length() && s.charAt(l) == s.charAt(h)) {
                if(h-l+1 > end) {
                    start = l;
                    end = h-l+1;
                }
                l--;
                h++;
            }
            
        }
        ans = s.substring(start,start+end);
        return ans;
        
    }
}
