import java.util.*;

public class _34ValidPalindrome2LC680 {

    private static boolean isPalindrome(String s,int i,int j) {
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false; 
            }
            i++;
            j--;
        }
        return true;
    }
  // ~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~
  public static boolean validPalindrome(String s) {
    int i = 0;
    int j = s.length()-1;
    while(i < j) {
        if(s.charAt(i) != s.charAt(j)) {
            return isPalindrome(s,i+1,j) || isPalindrome(s,i,j-1); 
        }
        i++;
        j--;
    }
    return true;
  }

  // ~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.nextLine();

    boolean res = validPalindrome(str);
    System.out.println(res);
  }
}