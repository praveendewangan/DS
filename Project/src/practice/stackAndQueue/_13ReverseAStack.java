package practice.stackAndQueue;

import java.util.Stack;

public class _13ReverseAStack {
    // O(2^n),O(1)
    static Stack<Character> st = new Stack<>();
    public static void main(String[] args) {
         // push elements into
        // the stack
        st.push('1');
        st.push('2');
        st.push('3');
        st.push('4');
          
        System.out.println("Original Stack");
          
        System.out.println(st);
          
        reverse();
          
        System.out.println("Reversed Stack");
          
        System.out.println(st);
    }

    private static void reverse(){
        if(st.size() > 0) {
            char ch = st.pop();
            reverse();
            insertAtBottom(ch);
        }
    }

    private static void insertAtBottom(char ch) {
        if(st.size() == 0){
            st.push(ch);
        } else {
            char x = st.pop();
            insertAtBottom(ch);
            st.push(x);
        }
    }
}
