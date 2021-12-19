import java.io.*;
import java.util.*;

public class _13RemoveKDigitsLC402 {

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String num = read.readLine();
        int k = Integer.parseInt(read.readLine());

        Stack<Character> st = new Stack<>();
        for(char ch : num.toCharArray()){
            while(st.size() > 0 && k > 0 && st.peek() > ch) {
                st.pop();
                k--;
            }
            st.push(ch);
        }
        
        while(k > 0) {
            st.pop();
            k--;
        }
        
        char[] arr = new char[st.size()];
        int idx = arr.length-1;
        while(idx >= 0) {
            arr[idx--] = st.pop();
        }
        int d = 0;
        while(d < arr.length && arr[d] == '0') d++;
        
        StringBuilder sb = new StringBuilder();
        while(d < arr.length) sb.append(arr[d++]);
        
        if(sb.length() == 0) {
            sb.append('0');
        }
        System.out.println(sb.toString());
    }
}