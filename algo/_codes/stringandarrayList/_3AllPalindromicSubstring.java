package _codes.stringAndArrayList;

import java.util.List;

public class _3AllPalindromicSubstring {
    private static void substring(String str) {
        int n = str.length();
        for(int i = 0; i < n ; i++) {
            for(int j = i; j < n; j++) {
                if(isPalindrome(str,i,j)) {
                    String s = str.substring(i, j+1);
                    System.out.println(s);
                }
            }
        }
    }    

    private static boolean isPalindrome(String s,int i, int j) {
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
