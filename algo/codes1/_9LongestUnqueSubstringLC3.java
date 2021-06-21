public class _9LongestUnqueSubstringLC3 {
    // Input: s = "abcabcbb"
    // Output: 3
    // Explanation: The answer is "abc", with the length of 3.
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        Map<Character,Integer> mp = new HashMap<>();
        int i = 0;
        int j = 0;
        int winLen = 0;
        int maxWinLen = 0;
        int startIdx = -1;
        int n = s.length();
        while(j < n) {
            char ch = s.charAt(j);
//             Check if character already present in map and position of character
            // should be greater than i otherwise no need to make new window
            if(mp.containsKey(ch) && mp.get(ch) >= i) {
                i = mp.get(ch) + 1;
                winLen = j - i;
            }
//             Update char position in map each time
            mp.put(ch,j);
            winLen++;
            j++;
            
            if(winLen > maxWinLen) {
                maxWinLen = winLen;
                startIdx = i;
            }
        }
        return maxWinLen;
    }
}
