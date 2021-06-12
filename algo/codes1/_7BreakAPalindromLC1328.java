import java.util.*;
public class _7BreakAPalindromLC1328 {
    // BruteForce
    public String breakPalindrome(String s) {
        if(s == null || s.length() == 0) return "";
           String ans = "";
           for(int i = 0; i < s.length(); i++) {
               for(char ch = 'a'; ch <= 'z'; ch += 1) {
                   if(s.charAt(i) != ch) {
                       StringBuilder s2 = new StringBuilder(s);
                       s2.setCharAt(i,ch);
                       if(!isPalindrome(s2.toString())) {
                           if(ans.length() == 0) {
                               ans = s2.toString();
                           } else {
                               if(s2.toString().compareTo(ans) <= 0 ) {
                                   ans = s2.toString();
                               } 
                           }
                       }
                   }
               }
           }
           return ans;
       }
       
       private boolean isPalindrome(String s) {
           int i = 0;
           int j = s.length() - 1;
           while(i < j) {
               if(s.charAt(i) != s.charAt(j)) {
                   return false;
               }
               i++;
               j--;
           }
           return true;
       }

    //    Efficient 
    public String breakPalindrome(String s) {
        if(s == null || s.length() == 0) return "";
           String ans = "";
           int n = s.length();
           if(n == 1) return "";
           StringBuilder sb = new StringBuilder(s);
           for(int i = 0; i < n; i++) {
               int j = n - i - 1;
               if(i == j) continue;
               if(sb.charAt(i) != 'a') {
                   sb.setCharAt(i,'a');
                   return sb.toString();
               }
           }
           sb.setCharAt(n-1,'b');
                   return sb.toString();
       }
}
