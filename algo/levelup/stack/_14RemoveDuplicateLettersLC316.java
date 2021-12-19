import java.io.*;
import java.util.*;

public class _14RemoveDuplicateLettersLC316 {
    public static String removeDuplicateLetters(String s) {
        int[] freq = new int[26];
        boolean[] exist = new boolean[26];
        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
        }
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){
            freq[ch-'a']--;
            if(exist[ch-'a']) continue;
            
            while(st.size() > 0 && st.peek() > ch && freq[st.peek() - 'a'] > 0) {
                char rm = st.pop();
                exist[rm-'a'] = false;
            }
            st.push(ch);
            exist[ch-'a'] = true;
        }
        char[] ans = new char[st.size()];
        int i = ans.length-1;
        while(i >= 0) {
            ans[i--] = st.pop();
        }
        return new String(ans);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String result = removeDuplicateLetters(read.readLine());
        System.out.println(result);
        
    }
}
