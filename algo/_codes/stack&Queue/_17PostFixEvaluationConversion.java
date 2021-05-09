public class _17PostFixEvaluationConversion {
    public static void main(String[] args) {
        evaluation("264*8/+3-");
        // 2
        // ((2+((6*4)/8))-3)
        // -+2/*6483
    }
    private static void evaluation(String str) {
        Stack<Integer> eva = new Stack<>();
        Stack<String> pre = new Stack<>();
        Stack<String> inf = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(ch >= '0' && ch <= '9') {
                pre.push(ch + "");
                inf.push(ch + "");
                eva.push((int)(ch - '0'));
            } else if(ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                String prev2 = pre.pop();
                String prev1 = pre.pop();
                String preVal = ch + prev1 + prev2;
                pre.push(preVal);

                String infv2 = inf.pop();
                String infv1 = inf.pop();
                String infVal =  "(" + infv1 + ch + infv2 + ")";
                inf.push(infVal);

                int v2 = eva.pop();
                int v1 = eva.pop();
                int val = getProcess(v1, v2, ch);
                eva.push(val);
                        
            } 
        }
        System.out.println(eva.pop());
        System.out.println(inf.pop());
        System.out.println(pre.pop());
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
}
