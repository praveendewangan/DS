
import java.io.*;
import java.util.*;

public class _5IsBracketBalanced {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        System.out.println(isBalanced(str));
    }
    
    private static boolean isBalanced(String str) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < str.length();i++){
            char ch = str.charAt(i);
            if(ch == '[' || ch == '{' || ch == '('){
                st.push(ch);
            } else if(ch == ']' || ch == '}' || ch == ')') {
                if(st.size() == 0) {
                    return false;
                }
                if(ch == ']'){
                    if(st.peek() == '[') {
                        st.pop();
                    } else {
                        return false;
                    }
                } else if(ch == '}') {
                    if(st.peek() == '{') {
                        st.pop();
                    } else {
                        return false;
                    }
                } else {
                    if(st.peek() == '(') {
                        st.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return st.isEmpty();
    }

}