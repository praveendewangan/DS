public class _18PrefixEvaluationConversion {
    public static void main(String[] args) {
        evaluation("-+2/*6483");
    }    
    private static void evaluation(String str){
        Stack<Integer> eva = new Stack<>();
        Stack<String> post = new Stack<>();
        Stack<String> inf = new Stack<>();
        for(int i = str.length() - 1; i >= 0; i--){
            char ch = str.charAt(i);
            if(ch >= '0' && ch <= '9') {
                post.push(ch + "");
                inf.push(ch + "");
                eva.push((int)(ch - '0'));
            } else if(ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                String postv1 = post.pop();
                String postv2 = post.pop();
                String postVal = postv1 + postv2 + ch;
                post.push(postVal);
    
                String infv1 = inf.pop();
                String infv2 = inf.pop();
                String infVal =  "(" + infv1 + ch + infv2 + ")";
                inf.push(infVal);
    
                int v1 = eva.pop();
                int v2 = eva.pop();
                int val = getProcess(v1, v2, ch);
                eva.push(val);
                        
            } 
        }
        System.out.println(eva.pop());
        System.out.println(inf.pop());
        System.out.println(post.pop());   
        
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
