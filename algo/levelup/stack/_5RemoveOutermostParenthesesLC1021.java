import java.io.*;
import java.util.*;

public class _5RemoveOutermostParenthesesLC1021 {
  public static String removeOuterParentheses(String s) {
    StringBuilder sb = new StringBuilder();
    Stack<Character> st = new Stack<>();
    for(char ch : s.toCharArray()) {
        if(ch == '(') {
            if(st.size() > 0) {
                sb.append(ch);
            }
            st.push(ch);
        } else {
            st.pop();
            if(st.size() > 0) {
                sb.append(ch);
            }
        }
    }
    return sb.toString();
  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    String result = removeOuterParentheses(read.readLine());
    System.out.println(result);
  }
}
