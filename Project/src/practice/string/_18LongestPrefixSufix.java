package practice.string;

public class _18LongestPrefixSufix {
    // Efficiecnt Approch O(n+m)
    int lps(String s) {
        int l = s.length();
        int count = 0;
        int len = 0;
        int i = 1;
        int[] dp = new int[l];
        
        while(i < l) {
            if(s.charAt(i) == s.charAt(len)) {
                dp[i] = ++len;
                i++;
            } else {
                if(len != 0){
                    len = dp[len-1];
                } else {
                    dp[i] = 0;
                    i++;
                }
            }
        }
        int res = dp[l-1];
        return res;
    }


    // 2nd approch

    // Function to find largest prefix 
   // which is also a suffix
   static int longestPrefixSuffix(String s) 
   {
      int n = s.length();
 
      // If n is less than 2
      if(n < 2) {
          return 0;
      }
 
      int len = 0;
      int i = (n + 1)/2;
 
      // Iterate i till n
      while(i < n)
      {
 
        // If s[i] is equal to 
        // s[len]
        if(s.charAt(i) == s.charAt(len)) 
        {
          ++len;
          ++i;
        }
        else
        {
          i = i - len + 1;
          len = 0;
        }
      }
 
      // Return len
      return len;
 
  }
}
