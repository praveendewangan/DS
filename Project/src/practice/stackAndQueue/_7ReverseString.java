package practice.stackAndQueue;

import java.util.Stack;

public class _7ReverseString {
    // O(n),O(n)
    public String reverse(String S){
        Stack<Character> st = new Stack<>();
        for(char ch : S.toCharArray()){
            st.push(ch);
        }
        StringBuilder sb = new StringBuilder();
        while(st.size() > 0) {
            sb.append(st.pop());
        }
        return sb.toString();
    }
}
