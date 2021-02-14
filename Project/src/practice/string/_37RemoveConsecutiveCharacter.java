package practice.string;

import java.util.Stack;

public class _37RemoveConsecutiveCharacter {
    // O(n),O(n)
    public String removeConsecutiveCharacter(String S){
        Stack<Character> st = new Stack<>();
        
        for(char ch : S.toCharArray()){
            if(st.size() == 0){
                st.push(ch);
            } else if(st.peek() != ch){
                st.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(st.size() != 0) {
            char ch = st.pop();
            sb.insert(0,ch);
        }
        return sb.toString();
    }
}
