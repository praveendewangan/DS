package practice.string;

public class _2CheckPalindromeString {
    int isPlaindrome(String s) {
        int i=0;
        int j=s.length()-1;
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)){
                return 0;
            }
            i++;
            j--;
        }
        return 1;
    } 
}
