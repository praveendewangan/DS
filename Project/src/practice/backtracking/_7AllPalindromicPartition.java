package practice.backtracking;

public class _7AllPalindromicPartition {
    public static void main(String[] s) {
        helper("geeks","");
    }

    private static void helper(String s,String asf) {
        if(s.length() == 0) {
            System.out.println(asf);
            return;
        }
        for(int i=0;i<s.length();i++) {
            String prefix = s.substring(0, i+1);
            String sufix = s.substring(i+1);
            if(isPalindrome(prefix)) {
                helper(sufix, asf+"("+prefix+")");
            }
        }
    }
    private static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while(i < j) {
            char left = s.charAt(i);
            char right = s.charAt(j);
            if(left != right) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

