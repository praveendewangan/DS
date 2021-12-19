import java.io.*;
import java.util.*;

public class _8MinimumRemovetoMakeValidParenthesesLC1249 {
    public static String reverseParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                st.push(i);
            } else if(ch == ')') {
                if(st.size() == 0 || s.charAt(st.peek()) == ')') {
                    st.push(i);
                }  else {
                    st.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = s.length()-1; i >= 0; i--){
            if(st.size() > 0 && i == st.peek()) {
                st.pop();
            } else {
                sb.append(s.charAt(i));
            }
        }
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String result = reverseParentheses(read.readLine());
        System.out.println(result);
        
    }
}
