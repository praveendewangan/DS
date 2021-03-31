package practice.stackAndQueue;
import java.util.*;
public class _6ParenthesisChecker {
    // O(n),O(n)
    static boolean ispar(String x)
    {
        Stack<Character> st = new Stack<>();
        for(char ch : x.toCharArray()){
            if(st.size() == 0){
                st.push(ch);
            } else if(ch == '{' || ch == '[' || ch == '('){
                st.push(ch);
            } else {
                char c = st.peek();
                if((c == '{' && ch == '}')
                   || (c == '[' && ch == ']')
                   || (c == '(' && ch == ')')){
                    st.pop();
                } else {
                    st.push(ch);
                }
            }
        }
        if(st.size() > 0) return false;
        return true;
    }
}
