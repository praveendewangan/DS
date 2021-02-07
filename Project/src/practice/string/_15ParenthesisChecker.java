package practice.string;

import java.util.Stack;

public class _15ParenthesisChecker {
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
                if(   (c == '{' && ch == '}')
                   || (c == '[' && ch == ']')
                   || (c == '(' && ch == ')') ){
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
