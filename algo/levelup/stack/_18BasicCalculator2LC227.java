import java.io.*;
import java.util.*;

public class _18BasicCalculator2LC227 {
  public static int calculate(String s) {
    return evaluation(s);
  }
      private static int evaluation(String str) {
            Stack<Character> opt = new Stack<>();
            Stack<Integer> opn = new Stack<>();
            for(int i = 0; i < str.length(); i++){
                char ch = str.charAt(i);
                if(ch == '('){
                    opt.push(ch);
                } else if(ch >= '0' && ch <= '9') {
                    String num = "";
                    while(i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                        num += str.charAt(i) + "";
                        i++;
                    }
                    opn.push(Integer.parseInt(num));
                    i--;
                } else if(ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                        while(!opt.isEmpty() && opt.peek() != '(' && getPriority(opt.peek()) >= getPriority(ch)) {
                            int v2 = opn.pop();
                            int v1 = opn.pop();
                            char operator = opt.pop();
                            int val = getProcess(v1,v2,operator);
                            opn.push(val);
                        }
                        opt.push(ch);
                } else if(ch == ')'){
                    while(opt.peek() != '(') {
                        int v2 = opn.pop();
                        int v1 = opn.pop();
                        char operator = opt.pop();
                        int val = getProcess(v1,v2,operator);
                        opn.push(val);
                    }
                    opt.pop();
                }
            }
            while(!opt.isEmpty()) {
                int v2 = opn.pop();
                int v1 = opn.pop();
                char operator = opt.pop();
                int val = getProcess(v1,v2,operator);
                opn.push(val);
            }
            return opn.pop();
        }
        private static int getProcess(int v1, int v2, char ch) {
            if(ch == '+'){
                return v1 + v2;
            } else if(ch == '-') {
                return v1 - v2;
            } else if(ch == '*') {
                return v1 * v2;
            } else {
                return v1 / v2;
            }
        }
        private static int getPriority(char ch){
            if(ch == '*' || ch == '/'){
                return 2;
            } else if(ch == '+' || ch == '-') {
                return 1;
            } else {
                return 0;
            }
        }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    int result = calculate(read.readLine());
    System.out.println(result);

  }
}
