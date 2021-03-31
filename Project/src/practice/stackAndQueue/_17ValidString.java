package practice.stackAndQueue;

import java.util.Stack;

public class _17ValidString {
    // O(n),O(n)
    static int findMaxLen(String S) {
        Stack<Integer> st = new Stack<>();
        int len = S.length();
        int res = 0;
        st.push(-1);
        for(int i=0;i < len;i++){
            char ch = S.charAt(i);
            if(ch == '('){
                st.push(i);
            } else {
                if(!st.isEmpty()){
                    st.pop();
                } 
                if(!st.isEmpty()){
                    res = Math.max(res , i - st.peek());
                } else {
                    st.push(i);
                }
            }
        }
        return res;
    }
}
