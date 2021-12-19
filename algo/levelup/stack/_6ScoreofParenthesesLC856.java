import java.io.*;
import java.util.*;

public class _6ScoreofParenthesesLC856 {
    public static int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        for(char ch : s.toCharArray()) {
            if(ch == '(') {
                st.push(-1); 
            } else {
                if(st.peek() == -1) {
                    st.pop();
                    st.push(1);
                } else {
                    int val = 0;
                    while(st.peek() != -1) {
                        val += st.pop();
                    }
                    st.pop();
                    st.push(2*val);
                }
            }
        }
        int val = 0;
        while(st.size() > 0) {
            val += st.pop();
        }
        return val;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int score = scoreOfParentheses(read.readLine());
        System.out.println(score);
        
    }
}
