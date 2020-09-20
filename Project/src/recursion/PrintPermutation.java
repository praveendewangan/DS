package recursion;

public class PrintPermutation {
    public static void main(String[] args) {
        print("abc","");
    }
    private static void print(String ques,String ans) {
        if (ques.length() == 0) {
            System.out.println(ans);
            return ;
        }

        for (int i = 0; i < ques.length(); i++) {
            char ch = ques.charAt(i);
            String left = ques.substring(0,i);
            String right = ques.substring(i+1);
            print(left+right,ans+ch);
        }
    }
}
