package practice.stackAndQueue;

import java.util.Stack;

public class _18RedundantBracket {
    // O(n),O(n)
    public static void main(String[] args) {
        String str = "((a+b))";
        findRedundant(str);
  
        str = "(a+(b)/c)";
        findRedundant(str);
  
        str = "(a+b*(c-d))";
        findRedundant(str);
    }

    private static void findRedundant(String str){
        if(checkBracket(str)){
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

    private static boolean checkBracket(String str) {
        Stack<Character> st = new Stack<>();
        char[] a = str.toCharArray();
        for(char ch : a) {
            if(ch == ')') {
                char top = st.pop();
                
                boolean flag = true; 
                while(top != '(') {
                    if(top == '+' || top == '-' || top == '*' || top == '/'){
                        flag = false;
                    }
                    top = st.pop();
                }
                if(flag) {
                    return true;
                }
            } else {
                st.push(ch);
            }
        }
        return false;
    }

}
