import java.io.*;
import java.util.*;

public class _16InfixConversion {  

        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String exp = br.readLine();
            evaluation(exp);
            // code
        }
           private static void evaluation(String str) {
            Stack<Character> opt = new Stack<>();
            Stack<String> pre = new Stack<>();
            Stack<String> post = new Stack<>();
            for(int i = 0; i < str.length(); i++){
                char ch = str.charAt(i);
                if(ch == ' ') {
                    continue;
                } else if(ch == '('){
                    opt.push(ch);
                } else if(ch >= 'a' && ch <= 'z') {
                    pre.push(ch + "");
                    post.push(ch + "");
                } else if(ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                        while(!opt.isEmpty() && opt.peek() != '(' && getPriority(opt.peek()) >= getPriority(ch)) {
                            String prev2 = pre.pop();
                            String prev1 = pre.pop();
                            char operator = opt.pop();
                            String preVal = operator + prev1 + prev2;
                            pre.push(preVal);

                            String postv2 = post.pop();
                            String postv1 = post.pop();
                            String postVal =  postv1 + postv2 + operator;
                            post.push(postVal);
                            
                        }
                        opt.push(ch);
                } else if(ch == ')'){
                    while(opt.peek() != '(') {
                        String prev2 = pre.pop();
                        String prev1 = pre.pop();
                        char operator = opt.pop();
                        String preVal = operator + prev1 + prev2;
                        pre.push(preVal);

                        String postv2 = post.pop();
                        String postv1 = post.pop();
                        String postVal =  postv1 + postv2 + operator;
                        post.push(postVal);
                    }
                    opt.pop();
                }
            }
            while(!opt.isEmpty()) {
                String prev2 = pre.pop();
                String prev1 = pre.pop();
                char operator = opt.pop();
                String preVal = operator + prev1 + prev2;
                pre.push(preVal);

                String postv2 = post.pop();
                String postv1 = post.pop();
                String postVal =  postv1 + postv2 + operator;
                post.push(postVal);
            }
            System.out.println(post.pop());
            System.out.println(pre.pop());
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
}
