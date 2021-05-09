import java.util.Stack;

public class _15InfixEvaluation {
    public static void main(String[] args) {
        String str = "2+3*2-(3+4*1)";
        evaluation(str);
    }   
     private static void evaluation(String str) {
            Stack<Character> opt = new Stack<>();
            Stack<Integer> opn = new Stack<>();
            for(int i = 0; i < str.length(); i++){
                char ch = str.charAt(i);
                if(ch == '('){
                    opt.push(ch);
                } else if(ch >= '0' && ch <= '9') {
                    opn.push((int)(ch - '0'));
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
            System.out.println(opn.pop());
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
    }