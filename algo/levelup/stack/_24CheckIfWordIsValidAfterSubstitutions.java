import java.io.*;
import java.util.*;

public class _24CheckIfWordIsValidAfterSubstitutions {
  public static boolean isValid(String s) {
    Stack<Character> st = new Stack<>();
    for(char ch : s.toCharArray()){
        if(ch == 'c') {
            if(!(st.size() >= 2 && st.pop() == 'b' && st.pop() == 'a')){
                return false;
            }
        } else {
            st.push(ch);
        }
    }

    return st.size() == 0;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    boolean result = isValid(read.readLine());
    System.out.println(result);

  }
}
