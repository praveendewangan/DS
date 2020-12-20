package recursion;

public class _18PrintSubsequence {
    public static void main(String[] args) {
        print("abc","");
    }

    private static void print(String ques,String ans) {
        if(ques.length() == 0) {
            System.out.println(ans);
            return;
        }
        char ch = ques.charAt(0);
        String sb = ques.substring(1);
        print(sb,ans + ch);
        print(sb,ans );
    }
}
