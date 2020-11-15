package stackandqueue;

import java.util.Scanner;
import java.util.Stack;

public class _2BalancedBrackets {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '[' || ch == '{' || ch == '(') {
                st.push(ch);
            } else if(ch == ')') {
                boolean val = handleClosing('(',st);
                if(!val) {
                    System.out.println(val);
                    return;
                }
            } else if(ch == '}') {
                boolean val = handleClosing('{',st);if(!val) {
                    System.out.println(val);
                    return;
                }
            } else if(ch == ']') {
                boolean val = handleClosing('[',st);if(!val) {
                    System.out.println(val);
                    return;
                }
            }
        }
        if(st.size() == 0) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
    private static boolean handleClosing(char ch,Stack<Character> st) {
        if(st.size() == 0) {
            return false;
        } else if(st.peek() != ch) {
            return false;
        } else {
            st.pop();
            return true;
        }
    }
}
