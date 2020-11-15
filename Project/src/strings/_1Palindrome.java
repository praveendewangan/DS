package strings;

import java.util.Scanner;

public class _1Palindrome {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.next();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                System.out.println(s.substring(i,j));
            }
        }
        System.out.println(isPalindrome(s));
    }

    private static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);
            if(c1 == c2) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}
