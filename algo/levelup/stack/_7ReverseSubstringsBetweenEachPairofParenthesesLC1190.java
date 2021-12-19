import java.io.*;
import java.util.*;

public class _7ReverseSubstringsBetweenEachPairofParenthesesLC1190 {
    public static String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()) {
            if(ch == ')') {
                StringBuilder sb = new StringBuilder();
                while(st.size() > 0 && st.peek() != '(') {
                    sb.append(st.pop());
                }
                st.pop();
                for(int i = 0; i < sb.length(); i++){
                    st.push(sb.charAt(i));
                }
            } else {
                st.push(ch);
            }
        }
        String str = "";
        while(st.size() > 0) {
            str = st.pop() + str;
        }
        return str;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String result = reverseParentheses(read.readLine());
        System.out.println(result);
        
    }
}
