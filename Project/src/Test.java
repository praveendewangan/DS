import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Test {
    private static int findTotalMaxSum(int[] a,int[] b) {
        int sum1 = 0;
        int sum2 = 0;
        int i = 0;
        int j = 0;
        int result = 0;
        int m = a.length;
        int n = b.length;
        while(i < m && j < n) {
            if(a[i] < b[j]){
                sum1 += a[i++];
            } else if(a[i] > b[j]) {
                sum2 += a[j++];
            } else {
                result += Math.max(sum1,sum2);
                sum1 = 0;
                sum2 = 0;
                while(i < m && j < n && a[i] == b[j]) {
                    result += a[i];
                    i++;
                    j++;
                }
            }
        }
        while(i < m) {
            sum1 += a[i++];
        }
        while(j < n) {
            sum2 += b[j++];
        }
        result += Math.max(sum1, sum2);
        return result;
    }
    private static int countPermutation(String bigstr,String smallstr){
        int hsVal = 0;
        for(char ch : smallstr.toCharArray()){
            hsVal += ch;
        }
        int count = 0;
        int txtval = 0;
        for(int i=0;i<smallstr.length();i++){
            txtval += bigstr.charAt(i);
        }
        if(txtval == hsVal){
            count++;
        }
        for(int i=1;i<=bigstr.length()-smallstr.length();i++){
            txtval = 0;
            for(int j=i;j<i+smallstr.length();j++){
                txtval += bigstr.charAt(j);
            }
            if(txtval == hsVal){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) throws IOException {
        System.out.println(countPermutation("cbabcacabca","abc"));
        // System.out.println(findTotalMaxSum(new int[]{1, 2, 8, 9, 10, 15, 20},new int[]{7, 8, 10, 11, 20, 25}));
        System.exit(0);
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] p = br.readLine().trim().split(" ");
//        int n = Integer.parseInt(br.readLine());
//        int[][] arr = new int[n][2];
//
//        for (int j = 0; j < n; j++) {
//            String[] s = br.readLine().trim().split(" ");
//            for (int k = 0; k < arr[0].length; k++) {
//                arr[j][k] = Integer.parseInt(s[k]);
//            }
//        }

//        String str = br.readLine().trim();
//        System.out.println(nextGreaterElement(a));
//        smallestNumFolloPattern(str);
        int[] a = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,100,-1,-1,90,-1,-1,40,100,-1,-1,-1};
        Stack<Node> st = new Stack<>();
        Node root = null;
        for (int i = 0; i < a.length; i++) {
            if(a[i] == -1){
                st.pop();
            } else {
                Node node = new Node();
                node.data = a[i];
                if(st.size() == 0) {
                    root = node;
                } else {
                    Node top = st.peek();
                    top.childrean.add(node);
                }
                st.push(node);
            }
        }
        display(root);
    }
    private static void display(Node node) {
        String str = node.data + " -> ";
        for (Node child : node.childrean) {
            str += child.data + ",";
        }
        System.out.println(str);
        for (Node child : node.childrean) {
            display(child);
        }
    }
    private static class Node {
        int data;
        List<Node> childrean = new ArrayList<>();
    }
    private static void smallestNumFolloPattern(String str) {
        Stack<Integer> st = new Stack<>();
        int num = 1;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == 'd') {
                st.push(num);
                num++;
            } else {
                st.push(num);
                num++;
                while (st.size() != 0) {
                    System.out.print(st.pop());
                }
            }
        }
        st.push(num);
        while (st.size() != 0) {
            System.out.print(st.pop());
        }
    }
    private static void mergeoverlap(int[][] a) {
        Pair[] pairs = new Pair[a.length];
        for (int i = 0; i < a.length; i++) {
            pairs[i] = new Pair(a[i][0],a[i][1]);
        }
        Arrays.sort(pairs);
        Stack<Pair> st = new Stack<>();
        st.push(pairs[0]);
        for (int i = 1; i < pairs.length; i++) {
            Pair top = st.peek();
            if(pairs[i].st > top.et) {
                st.push(pairs[i]);
            } else {
                top.et = Math.max(pairs[i].et,top.et);
            }
        }
        Stack<Pair> rst = new Stack<>();
        while (st.size() != 0) {
            rst.push(st.pop());
        }
        while (rst.size() != 0) {
            Pair p = rst.pop();
            System.out.println(p.st + " - " + p.et);
        }
    }
    public static class Pair implements Comparable<Pair>{
        int st;
        int et;
        public Pair(int st,int et) {
            this.st = st;
            this.et = et;
        }

        @Override
        public int compareTo(Pair o) {
            if(this.st != o.st) {
                return this.st - o.st;
            } else {
                return this.et - o.et;
            }
        }
    }
    private static void findCelebrity(int[][] a) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < a.length; i++) {
            st.push(i);
        }
        while (st.size() >= 2) {
            int i = st.pop();
            int j = st.pop();
            if(a[i][j] == 1) {
                st.push(j);
            } else {
                st.push(i);
            }
        }
        int pot = st.pop();
        for (int i = 0; i < a.length; i++) {
            if(i != pot){
                if(a[i][pot] == 0 || a[pot][i] == 1) {
                    System.out.println("none");
                    return;
                }
            }
        }
        System.out.println(pot);
    }
    private static void prefixEvalAndConversion(String str) {
        Stack<String> infix = new Stack<>();
        Stack<String> postfix = new Stack<>();
        Stack<Character> op = new Stack<>();
        Stack<Integer> od = new Stack<>();
        for (int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            if(ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                int v1 = od.pop();
                int v2 = od.pop();
                int val = operation(v1,v2,ch);
                od.push(val);
                String infv1 = infix.pop();
                String infv2 = infix.pop();
                String infixv = "(" + infv1 + ch + infv2 + ")";
                infix.push(infixv);
                String prev1 = postfix.pop();
                String prev2 = postfix.pop();
                String prefixv = prev1 + prev2 + ch + "";
                postfix.push(prefixv);
            } else if(Character.isDigit(ch)) {
                infix.push(ch + "");
                postfix.push(ch + "");
                od.push(ch - '0');
            }
        }
        System.out.println(od.peek());
        System.out.println(infix.peek());
        System.out.println(postfix.peek());
    }
    private static void postfixEvalAndConversion(String str) {
        Stack<String> infix = new Stack<>();
        Stack<String> prefix = new Stack<>();
        Stack<Character> op = new Stack<>();
        Stack<Integer> od = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                int v2 = od.pop();
                int v1 = od.pop();
                int val = operation(v1,v2,ch);
                od.push(val);
                String infv2 = infix.pop();
                String infv1 = infix.pop();
                String infixv = "(" + infv1 + ch + infv2 + ")";
                infix.push(infixv);
                String prev2 = prefix.pop();
                String prev1 = prefix.pop();
                String prefixv = ch + prev1 + prev2 + "";
                prefix.push(prefixv);
            } else if(Character.isDigit(ch)) {
                infix.push(ch + "");
                prefix.push(ch + "");
                od.push(ch - '0');
            }
        }
        System.out.println(od.peek());
        System.out.println(infix.peek());
        System.out.println(prefix.peek());
    }
    private static void infixConversion(String str) {

        Stack<String> pre = new Stack<>();
        Stack<String> post = new Stack<>();
        Stack<Character> op = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '(') {
                op.push(ch);
            }else if((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                pre.push(ch+"");
                post.push(ch+"");
            } else if(ch == ')') {
                while (op.peek() != '(') {
                    char opt = op.pop();
                    String postv2 = post.pop();
                    String postv1 = post.pop();
                    String postV = postv1+postv2+opt;
                    post.push(postV);

                    String prev2 = pre.pop();
                    String prev1 = pre.pop();
                    String preV = opt+prev1+prev2;
                    pre.push(preV);
                }
                op.pop();
            } else if(ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (op.size() > 0 && op.peek() != '(' && precedance(ch) <= precedance(op.peek())) {
                    char opt = op.pop();
                    String postv2 = post.pop();
                    String postv1 = post.pop();
                    String postV = postv1+postv2+opt;
                    post.push(postV);

                    String prev2 = pre.pop();
                    String prev1 = pre.pop();
                    String preV = opt+prev1+prev2;
                    pre.push(preV);
                }
                op.push(ch);
            }
        }
        while (op.size() > 0) {
            char opt = op.pop();
            String postv2 = post.pop();
            String postv1 = post.pop();
            String postV = postv1+postv2+opt;
            post.push(postV);

            String prev2 = pre.pop();
            String prev1 = pre.pop();
            String preV = opt+prev1+prev2;
            pre.push(preV);
        }
        System.out.println(pre.peek());
        System.out.println(post.peek());
    }
    private static void infixEvaluation(String str) {
        Stack<Integer> od = new Stack<>();
        Stack<Character> op = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '('){
                op.push(ch);
            }  else if(Character.isDigit(ch)) {
                od.push(ch - '0');
            } else if( ch == ')'){
                while (op.peek() != '(') {
                    char operator = op.pop();
                    int v2 = od.pop();
                    int v1 = od.pop();
                    int val = operation(v1,v2,operator);
                    od.push(val);
                }
                op.pop();
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                while (op.size() > 0 && op.peek() != '('
                        && precedance(ch) <= precedance(op.peek())) {
                    char operator = op.pop();
                    int v2 = od.pop();
                    int v1 = od.pop();
                    int val = operation(v1,v2,operator);
                    od.push(val);
                }
                op.push(ch);
            }
        }
        while (op.size() != 0) {
            char operator = op.pop();
            int v2 = od.pop();
            int v1 = od.pop();
            int val = operation(v1,v2,operator);
            od.push(val);
        }
        System.out.println(od.peek());
    }
    private static int precedance(char ch) {
        if(ch == '+' || ch == '-') {
            return 1;
        } else {
            return 2;
        }
    }
    private static int operation(int v1,int v2,char ch) {
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
    private static void LargestAreaHistogram(int[] a) {
        Stack<Integer> st = new Stack<>();
        int[] rb = new int[a.length];
        st.push(a.length-1);
        rb[a.length-1] = a.length;
        for (int i = a.length-2; i >= 0 ; i--) {
            while (st.size() > 0 && a[i] <= a[st.peek()]) {
                st.pop();
            }
            if(st.size() == 0) {
                rb[i] = a.length;
            } else {
                rb[i] = st.peek();
            }
            st.push(i);
        }
        st = new Stack<>();
        int[] lb = new int[a.length];
        st.push(0);
        lb[0] = -1;
        for (int i = 1; i < a.length ; i++) {
            while (st.size() > 0 && a[i] <= a[st.peek()]) {
                st.pop();
            }
            if(st.size() == 0) {
                lb[i] = -1;
            } else {
                lb[i] = st.peek();
            }
            st.push(i);
        }
        int maxArea = 0;
        for (int i = 0; i < a.length; i++) {
            int width = rb[i] - lb[i] - 1;
            int area = a[i] * width;
            if(area > maxArea) {
                maxArea = area;
            }
        }
        System.out.println(maxArea);
    }
    private static void stockSpan(int[] a) {
        int[] span =  new int[a.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        span[0] = 1;
        for (int i = 1; i < a.length; i++) {
            while (st.size() > 0 && a[i] > a[st.peek()]) {
                st.pop();
            }
            if(st.size() == 0) {
                span[i] = i+1;
            } else {
                span[i] = i -st.peek();
            }
            st.push(i);
        }
        for (int i = 0; i < span.length; i++) {
            System.out.println(span[i]);
        }
    }
    private static void nextGreaterElement(int[] a) {
        int[] nge = new int[a.length];
        Stack<Integer> st = new Stack<>();
        nge[a.length - 1] = -1;
        st.push(a[a.length-1]);
        for (int i = a.length-2; i >=0 ; i--) {
            while (st.size() > 0 && a[i] >= st.peek()) {
                st.pop();
            }

            if(st.size() == 0) {
                nge[i] = -1;
            } else {
                nge[i] = st.peek();
            }
            st.push(a[i]);
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(nge[i]);
        }
    }
    private static boolean balancedBrackets(String str) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else if(ch == ')') {
                if(!handleChar(st,'(')) {
                    return false;
                }
            } else if(ch == '}') {
                if(!handleChar(st,'{')) {
                    return false;
                }
            } else if(ch == ']') {
                if(!handleChar(st,'[')) {
                    return false;
                }
            }
        }
        if(st.size() > 0) {
            return false;
        } else {
            return true;
        }
    }
    private static boolean handleChar(Stack<Character> st,char ch) {
        if(st.size() == 0) {
            System.out.println(false);
            return false;
        } else if(st.peek() != ch) {
            System.out.println(false);
            return false;
        } else {
            st.pop();
            return true;
        }
    }
    private static boolean duplicateBrackets(String str) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == ')') {
                if(st.peek() == '('){
                    return true;
                } else {
                    while (st.peek() != '(') {
                        st.pop();
                    }
                    st.pop();
                }
            } else {
                st.push(ch);
            }
        }
        return false;
    }
    private static int bnsKTransactionAllowed(int[] a) {
        return 0;
    }
    private static int bnsTwoTransactionAllowed(int[] a) {
        int pist = 0;
        int leastist = a[0];
        int[] dpl = new int[a.length];
        for (int i = 1; i < a.length; i++) {
            if(a[i] < leastist) {
                leastist = a[i];
            }
            pist = a[i] - leastist;
            if(pist > dpl[i-1]) {
                dpl[i] = pist;
            } else {
                dpl[i] = dpl[i-1];
            }
        }
        int mpibt = 0;
        int maxat = a[a.length-1];
        int[] dpr = new int[a.length];
        for (int i = a.length-2; i >= 0 ; i--) {
            if(a[i] > maxat) {
                maxat = a[i];
            }
            mpibt = maxat - a[i];
            if(mpibt > dpr[i+1]) {
                dpr[i] = mpibt;
            } else {
                dpr[i] = dpr[i+1];
            }
        }
        int op=0;
        for (int i = 0; i < a.length; i++) {
            if(dpl[i] + dpr[i] > op) {
                op = dpl[i] + dpr[i];
            }
        }
        return op;
    }
    private static int bnsCooldownAndInfiniteTransactionAllowed(int[] a) {
        int obsp = -a[0];
        int ossp = 0;
        int cd = 0;
        for (int i = 1; i < a.length; i++) {
            int nbsp = 0;
            int nssp = 0;
            int ncsp = 0;
            if(cd - a[i] > obsp){
                nbsp = cd - a[i];
            } else {
                nbsp = obsp;
            }
            if(obsp+a[i]  > ossp) {
                nssp = obsp+a[i];
            } else {
                nssp = ossp;
            }
            if(cd < ossp){
                cd = ossp;
            } else {
                ncsp = cd;
            }
            obsp = nbsp;
            ossp = nssp;
        }
        return ossp;
    }
    private static int bnsTransactionFeeAndInfiniteTransactionAllowed(int[] a,int fee) {
        int obsp = -a[0];
        int ossp = 0;
        for (int i = 1; i < a.length; i++) {
            int nbsp = 0;
            int nssp = 0;
            if(ossp - a[i] > obsp){
                nbsp = ossp - a[i];
            } else {
                nbsp = obsp;
            }
            if(obsp+a[i] - fee > ossp) {
                nssp = obsp+a[i] - fee;
            } else {
                nssp = ossp;
            }
            obsp = nbsp;
            ossp = nssp;
        }
        return ossp;
    }
    private static int bnsInfiniteTransaction(int[] a,int n) {
        int bd = 0;
        int sd = 0;
        int profit = 0;
        for (int i = 1; i < a.length; i++) {
            if(a[i] >= a[i-1]) {
                sd++;
            } else {
                profit += a[sd] - a[bd];
                sd = bd = i;
            }
        }
        profit += a[sd] - a[bd];
        return profit;
    }
    private static int bnsOneTransaction(int[] a,int n) {
        int lsf = Integer.MAX_VALUE;
        int pist = 0;
        int op = 0;
        for (int i = 0; i < a.length; i++) {
            if(lsf > a[i]) {
                lsf = a[i];
            }
            pist = a[i] - lsf;
            if(pist > op) {
                op = pist;
            }
        }
        return op;
    }
    private static int partitionIntoSubset(int n,int k) {
        int[][] dp = new int[k+1][n+1];
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                if(j < i){
                    dp[i][j] = 0;
                } else if(j == i) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = i * dp[i][j-1] + dp[i-1][j-1];
                }
            }
        }
        return dp[k][n];
    }
    private static int friendsPair(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2] * (i-1);
        }
        return dp[n];
    }
    private static int tilesM_N(int n,int m) {
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            if(i < m) {
                dp[i] = 1;
            } else if(i == m) {
                dp[i] = 2;
            } else {{
                dp[i] = dp[i-1] + dp[i-m];
            }}
        }
        return dp[n];
    }
    private static int tiles2_1(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    private static int paintFence(int n , int k) {
        int same = k * 1;
        int diff = k * (k-1);
        int total = same + diff;
        for (int i = 3; i <= n; i++) {
            same = diff * 1;
            diff = total * (k-1);
            total = same + diff;
        }
        return total;
    }
    private static int paintHouseMulti(int[][] a) {
        int[][] dp = new int[a.length][a[0].length];
        int fmin = Integer.MAX_VALUE;
        int smin = Integer.MAX_VALUE;
        for (int i = 0; i < a[0].length; i++) {
            if(fmin >= a[0][i]){
                smin = fmin;
                fmin = a[0][i];
            } else if(smin >= a[0][i]){
                smin = a[0][i];
            }
            dp[0][i] = a[0][i];
        }
        for (int i = 1; i < a.length; i++) {
            int nfmin = Integer.MAX_VALUE;
            int nsmin = Integer.MAX_VALUE;
            for (int j = 0; j < a[0].length; j++) {
                if(fmin == dp[i-1][j]) {
                    dp[i][j] = a[i][j] + smin;
                } else {
                    dp[i][j] = a[i][j] + fmin;
                }
                if(nfmin >= dp[i][j]) {
                    nsmin = nfmin;
                    nfmin = dp[i][j];
                } else if(nsmin >= dp[i][j]) {
                    nsmin = dp[i][j];
                }
            }
            fmin = nfmin;
            smin = nsmin;
        }
        return fmin;
    }
    private static int paintHouse(int[][] a) {
        int[][] dp = new int[a.length][a[0].length];
        dp[0][0] = a[0][0];
        dp[0][1] = a[0][1];
        dp[0][2] = a[0][2];
        for (int i = 1; i < a.length; i++) {
            dp[i][0] = a[i][0] + Math.min(dp[i-1][1],dp[i-1][2]);
            dp[i][1] = a[i][1] + Math.min(dp[i-1][0],dp[i-1][2]);
            dp[i][2] = a[i][2] + Math.min(dp[i-1][0],dp[i-1][1]);
        }
        return Math.min(dp[a.length-1][0],Math.min(dp[a.length-1][1],dp[a.length-1][2]));
    }
    private static int maxSumNonAdjucentElement(int[] a) {
        int oinc = a[0];
        int oexc = 0;
        for (int i = 1; i < a.length; i++) {
            int ninc = oexc + a[i];
            int nexc = Math.max(oexc,oinc);

            oexc = nexc;
            oinc = ninc;
        }
        return Math.max(oexc,oinc);
    }
    private static int UnboundKnasack(int[] vals,int[] wts,int tar) {
        int[] dp = new int[tar+1];
        dp[0] = 0;
        for (int bagc = 1; bagc <= tar; bagc++) {
            int max = 0;
            for (int i = 0; i < wts.length; i++) {
                if(bagc >= wts[i]){
                    int rbagc = bagc - wts[i];
                    int bagv = dp[rbagc];
                    int tbagv = bagv + vals[i];
                    if(max > tbagv) {
                        max = tbagv;
                    }
                }
            }
            dp[bagc] = max;
        }
        return dp[tar];
    }
    private static int zeroOneKnasack(int[] vals,int[] wts,int tar) {
        int[][] dp = new int[wts.length + 1][tar + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(j >= wts[i-1]) {
                    int rcap = j-wts[i-1];
                    if(vals[i-1] + dp[i-1][rcap] > dp[i-1][j]) {
                        dp[i][j] = vals[i-1] + dp[i-1][rcap];
                    } else {
                        dp[i][j] = dp[i-1][j];
                    }
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[wts.length][tar];
    }
    private static int coinChangePerm1(int[] a,int amt) {
        int[] dp = new int[amt+1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if(i >= a[j]) {
                    dp[i] += dp[i-a[j]];
                }
            }
        }
        return dp[amt];
    }
    private static int coinChangeComb1(int[] a,int amt) {
        int[] dp = new int[amt+1];
        dp[0] = 1;
        for (int coin = 0; coin < a.length; coin++) {
            for (int j = a[coin]; j < dp.length; j++) {
                dp[j] += dp[j-a[coin]];
            }
        }
        return dp[amt];
    }
    private static boolean targetSumSubsets(int[] a, int tar) {
        boolean[][] dp =new boolean[a.length+1][tar+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if(i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if(i == 0) {
                    dp[i][j] = false;
                } else if(j == 0) {
                    dp[i][j] = true;
                } else {
                    if(dp[i-1][j]) {
                        dp[i][j] = true;
                    } else {
                        int val = a[i-1];
                        if(j >= val) {
                            if(dp[i-1][j-val]){
                                dp[i][j] = true;
                            }
                        }
                    }
                }
            }
        }
        return dp[a.length][tar];
    }
    private static int arrangeBuilding(int n) {
        int os = 1;
        int ob = 1;
        for (int i = 2; i <= n; i++) {
            int nb = os;
            int ns = os + ob;
            os = ns;
            ob = nb;
        }
        int total = os + ob;
        total = total * total;
        return total;
    }
    private static int countBinaryString(int n) {
        int cozeros = 1;
        int coones = 1;
        for (int i = 2; i <= n; i++) {
            int nczeros = coones;
            int ncones = coones + cozeros;
            coones = ncones;
            cozeros = nczeros;
        }
        return coones + cozeros;
    }
    private static int Unboundknapsack(int[] vals,int[] wts,int tar) {
        int[] dp = new int[tar+1];
        dp[0] = 0;
        for (int bagc = 1; bagc <= tar; bagc++) {
                int max = 0;
            for (int j = 0; j < wts.length; j++) {
                if(bagc >= wts[j]){
                    int rbagc = bagc - wts[j];
                    int rbagv = dp[rbagc];
                    int tbagv = rbagv + vals[j];
                    if(tbagv > max) {
                        max = tbagv;
                    }
                }
            }
            dp[bagc] = max;
        }
        return dp[tar];
    }
    private static int knapsack(int[] a,int[] b,int tar) {
        int[][] dp = new int[a.length+1][tar+1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(j >= b[i-1]) {
                    int rcap = j - b[i-1];
                    if(dp[i-1][rcap] + a[i-1] > dp[i-1][j]) {
                        dp[i][j] = dp[i-1][rcap] + a[i-1];
                    } else {
                        dp[i][j] = dp[i-1][j];
                    }
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[a.length][tar];
    }
    private static int coinChangePerm(int[] a,int m ) {
        int[] dp = new int[m+1];
        dp[0] = 1;
        for (int amt = 1; amt < dp.length; amt++) {
            for (int coin : a) {
                if(coin <= amt) {
                    int ramt = amt - coin;
                    dp[amt] += dp[ramt];
                }
            }
        }
        return dp[m];
    }
    private static int coinChangeComb(int[] a,int m ) {
        int[] dp = new int[m+1];
        dp[0] = 1;
        for (int i = 0; i < a.length; i++) {
            for (int j = a[i]; j < dp.length; j++) {
                dp[j] += dp[j-a[i]];
            }
        }
        return dp[m];
    }
    private static boolean targetSumSubsetRec(int[] a,int target,int idx,int count) {
        if(idx == a.length){
            return false;
        }
        if(count == target) {
            return true;
        }
        boolean flag1 = targetSumSubsetRec(a,target,idx+1,count + a[idx]);
        boolean flag2 = targetSumSubsetRec(a,target,idx+1,count);
        if(flag1 || flag2) {
            return true;
        } else {
            return false;
        }
    }
    private static boolean targetSumSubset(int[] a,int target) {
        boolean[][] dp = new boolean[a.length+1][target+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if(i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if(i == 0) {
                    dp[i][j] = false;
                } else if(j == 0) {
                    dp[i][j] = true;
                } else {
                    if(dp[i-1][j]) {
                        dp[i][j] = true;
                    } else {
                        int val = a[i-1];
                        if(j >= val) {
                            if(dp[i-1][j-val]) {
                                dp[i][j] = true;
                            }
                        }
                    }
                }
            }
        }
        return dp[a.length][target];
    }
    private static int goldmine(int[][] a) {
        Integer[][] dp = new Integer[a.length][a[0].length];
        for (int j = a[0].length - 1; j >= 0 ; j--) {
            for (int i = a.length-1; i >= 0; i--) {
                if(j == a[0].length - 1 ){
                    dp[i][j] = a[i][j];
                } else if(i == 0) {
                    dp[i][j] = a[i][j] + Math.max(dp[i][j+1],dp[i+1][j+1]);
                } else if(i == a.length - 1) {
                    dp[i][j] = a[i][j] + Math.max(dp[i][j+1],dp[i-1][j+1]);
                } else {
                    dp[i][j] = a[i][j] + Math.max(dp[i][j+1],Math.max(dp[i+1][j+1],dp[i-1][j+1]));
                }
            }
        }
            int max = dp[0][0];
            for (int i = 1; i < dp.length; i++) {
                if(dp[i][0] > max) {
                    max = dp[i][0];
                }
            }
            return max;
    }
    private static int minCostInMazeTraversal(int[][] a) {
        Integer[][] dp = new Integer[a.length][a[0].length];

        for (int i = dp.length-1; i >= 0 ; i--) {
            for (int j = dp[0].length - 1; j >= 0 ; j--) {
                if(i == dp.length - 1 && j == dp[0].length-1) {
                    dp[i][j] = a[i][j];
                } else if(i == dp.length - 1){
                    dp[i][j] = dp[i][j+1] + a[i][j];
                } else if(j == dp[0].length-1) {
                    dp[i][j] = dp[i+1][j] + a[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i][j+1] + a[i][j],dp[i+1][j] + a[i][j]);
                }
            }
        }
        return dp[0][0];
    }
    private static int getStairPathWithMinMoves(int[] a,int n) {
        Integer[] dp = new Integer[n+1];
        dp[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            if(a[i] > 0) {
                int min = Integer.MAX_VALUE;
                for (int j = 1; j <= a[i] && i+j < dp.length; j++) {
                    if(dp[i+j] != null) {
                        min = Math.min(min,dp[i+j]);
                    }
                }
                if(min != Integer.MAX_VALUE) {
                    dp[i] = min + 1;
                }
            }
        }
        return dp[0];
    }
    private static int getStairPathWithJump(int[] a,int n) {
        int[] dp = new int[n + 1];
        dp[n] = 1;
        for (int i = n-1; i >= 0; i--) {
            for (int j = 1; j <= a[i] && i + j < dp.length; j++) {
                dp[i] += dp[i+j];
            }
        }
        return dp[0];
    }
    private static int getStairPathCout(int n,int[] a) {
        if(n == 0) {
            return 1;
        } else if(n < 0) {
            return 0;
        }
        if(a[n] != 0) {
            return a[n];
        }
        int p1 = getStairPathCout(n - 1,a);
        int p2 = getStairPathCout(n - 2,a);
        int p3 = getStairPathCout(n - 3,a);
        a[n] = p1+p2+p3;
        return a[n];
    }
    private static int getStairPathCoutTab(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if(i == 1) {
                dp[i] = dp[i-1];
            } else if(i == 2) {
                dp[i] = dp[i-1] + dp[i-2];
            } else {
                dp[i] = dp[i - 1] + dp[i-2] + dp[i-3];
            }
        }
        return dp[n];
    }
    private static int fibonacci(int n,int[] a) {
        if(n == 0 || n == 1) {
            return n;
        }
        if(a[n] != 0) {
            return a[n];
        }
        int f1 = fibonacci(n-1,a);
        int f2 = fibonacci(n-2,a);
        a[n] = f1+f2;
        return a[n];
    }
    private static void quickSort(int[] a,int lo,int hi) {
        if(lo >= hi) {
            return;
        }
        int pivot = a[hi];
        int pi = partitionArray(a,pivot,lo,hi);
        quickSort(a,lo,pi-1);
        quickSort(a,pi+1,hi);
    }
    private static int partitionArray(int[] a,int pivot,int lo,int hi) {
        int i = lo;
        int j = lo;
        while (i <= hi) {
            if(a[i] <= pivot) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j-1;
    }
    private static int[] mergeSort(int[] a,int lo,int hi) {
        int mid = (lo + hi) / 2;
        int[] la = mergeSort(a,0 , mid - 1);
        int [] ra = mergeSort(a,mid + 1,hi);
        int[] res = mergeTwoSortedArray(la,ra);
        return res;
    }
    private static int[] mergeTwoSortedArray(int[] a,int[] b) {
        int[] c = new int[a.length+b.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < a.length && j < b.length) {
            if(a[i] < b[j]) {
                c[k] = a[i];
                i++;
            } else {
                c[k] = b[j];
                j++;
            }
            k++;
        }
        while (i < a.length) {
            c[k] = a[i];
            k++;
            i++;
        }

        while (j < b.length) {
            c[k] = b[j];
            k++;
            j++;
        }
        return c;
    }
    private static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i - 1; j >= 0 ; j--) {
                if(a[j] > a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                } else {
                    break;
                }
            }
        }
    }
    private static void selectionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int mi = i;
            for (int j = i + 1; j < a.length; j++) {
                if(a[j] < a[mi]) {
                    mi = j;
                }
            }
            int temp = a[i];
            a[i] = a[mi];
            a[mi] = temp;
        }
    }
    private static void bubbleSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if(a[i] < a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }
    private static void printNightTour(int[][] a,int row,int col,int move) {
        if(row < 0 || col < 0 || row >= a.length || col >= a[0].length || a[row][col] > 0) {
            return;
        } else if(move == a.length * a.length) {
            a[row][col] = move;
            print(a);
            a[row][col] = 0;
            return;
        }
        a[row][col] = move;
        printNightTour(a,row - 2,col + 1,move + 1);
        printNightTour(a,row - 1,col + 2,move + 1);
        printNightTour(a,row + 1,col + 2,move + 1);
        printNightTour(a,row + 2,col + 1,move + 1);
        printNightTour(a,row + 2,col - 1,move + 1);
        printNightTour(a,row + 1,col - 2,move + 1);
        printNightTour(a,row - 1,col - 2,move + 1);
        printNightTour(a,row - 2,col - 1,move + 1);
        a[row][col] = 0;
    }
    private static void print(int a[][]) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
    private static void printNQueens(int[][] a,String psf,int row) {
        if(row == a.length) {
            System.out.println(psf);
            return;
        }
        for (int col = 0; col < a.length; col++) {
            if(isQueenSafe(row,col,a)) {
                a[row][col] = 1;
                printNQueens(a,psf+row+"-"+col+",",row+1);
                a[row][col] = 0;
            }
        }
    }
    private static boolean isQueenSafe(int row,int col,int[][] a) {
        for (int i = row - 1,j=col; i >= 0; i--) {
            if(a[i][j] == 1) {
                return false;
            }
        }
        for (int i = row - 1,j=col-1; i >= 0 && j >=0; i--,j--) {
            if(a[i][j] == 1) {
                return false;
            }
        }
        for (int i = row - 1,j=col+1; i >= 0 && j < a.length; i--,j++) {
            if(a[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
    private static void printTargetSubsetSum(int[] a,int idx,int t,int sum,String asf) {
        if(t == sum) {
            System.out.println(asf);
            return;
        }
        if(idx == a.length) {
            return;
        }
        printTargetSubsetSum(a,idx+1,t,sum+a[idx],asf+a[idx]+",");
        printTargetSubsetSum(a,idx+1,t,sum,asf+"");
    }

    private static void floodFill(int a[][],int row,int col,String asf,boolean[][] visited) {
        if(row < 0 || col < 0 || row == a.length || col == a[0].length
                || a[row][col] == 1 || visited[row][col] == true) {
            return;
        }
        if(row == a.length-1 && col == a[0].length-1){
            System.out.println(asf);
            return;
        }
        visited[row][col] = true;
        floodFill(a,row-1,col,asf+"t",visited);
        floodFill(a,row,col-1,asf+"l",visited);
        floodFill(a,row+1,col,asf+"d",visited);
        floodFill(a,row,col+1,asf+"r",visited);
        visited[row][col] = false;
    }
    private static void printEncoding(String str,String asf) {
        if(str.length() == 0) {
            System.out.println(asf);
            return;
        } else if(str.length() == 1) {
            char ch = str.charAt(0);
            if(ch == '0') {
                return;
            } else {
                int chv = ch - '0';
                char code = (char) ('a' + chv - 1);
                asf += code;
                System.out.println(asf);
            }
        } else {
            char ch = str.charAt(0);
            String ss = str.substring(1);
            if(ch == '0') {
                return;
            } else {
                int chv = ch - '0';
                char code = (char) ('a' + chv - 1);
                printEncoding(ss,asf+code);
            }
            String ch12 = str.substring(0,2);
            String roq = str.substring(2);
            int ch12v = Integer.parseInt(ch12);
            if(ch12v <= 26) {
                char code = (char) ('a' + ch12v - 1);
                printEncoding(roq,asf+code);
            }
        }

    }
    private static void printPermutation(String str,String asf) {
        if(str.length() == 0) {
            System.out.println(asf);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String ss = str.substring(0,i) + str.substring(i+1);
            printPermutation(ss,asf+ch);
        }
    }
    private static void printMazePathsJump(int sr,int sc,int dr ,int dc,String asf) {
        if(sr == dr && sc == dc) {
            System.out.println(asf);
            return;
        }
        for (int ms = 1; ms+sc <= dc; ms++) {
            printMazePathsJump(sr,sc+ms,dr,dc,asf+"h"+ms);
        }
        for (int ms = 1; ms+sr <= dr; ms++) {
            printMazePathsJump(sr+ms,sc,dr,dc,asf+"v"+ms);
        }
        for (int ms = 1; ms+sr <= dr && ms+sc <= dc; ms++) {
            printMazePathsJump(sr+ms,sc+ms,dr,dc,asf+"d"+ms);
        }
    }
    private static void printMazePaths(int sr,int sc,int dr ,int dc,String asf) {
        if(sr == dr && sc == dc) {
            System.out.println(asf);
            return;
        } else if(sr > dr || sc > dc) {
            return;
        }
        printMazePaths(sr,sc+1,dr,dc,asf + "h");
        printMazePaths(sr+1,sc,dr,dc,asf + "v");
    }
    private static void printStairPaths(int n, String asf) {
        if(n == 0) {
            System.out.println(asf);
            return;
        } else if(n < 0) {
            return;
        }
        printStairPaths(n-1,asf + 1);
        printStairPaths(n-2,asf + 2);
        printStairPaths(n-3,asf + 3);
    }
    static String[] a = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    private static void printKpd(String str,String asf) {
        if(str.length() == 0) {
            System.out.println(asf);
            return;
        }
        char ch = str.charAt(0);
        String ss = str.substring(1);
        String key = a[ch - '0'];
        for (int i = 0; i < key.length(); i++) {
            char cho = key.charAt(i);
            printKpd(ss,asf + cho);
        }
    }
    private static void printSubSequence(String str,String asf) {
        if(str.length() == 0) {
            System.out.println(asf);
            return;
        }
        char ch = str.charAt(0);
        String ss = str.substring(1);
        printSubSequence(ss,asf+ch);
        printSubSequence(ss,asf+"");
    }
    private static List<String> getMazeJumpPath(int sr,int sc,int dr ,int dc) {
        if(sr == dr && sc == dc) {
            List<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        List<String> paths = new ArrayList<>();
        for (int ms = 1; ms+sc <= dc; ms++) {
            List<String> hpaths = getMazeJumpPath(sr,sc+ms,dr,dc);
            for (String s : hpaths) {
                paths.add("h"+ms+s);
            }
        }
        for (int ms = 1; ms+sr <= dr; ms++) {
            List<String> vpaths = getMazeJumpPath(sr+ms,sc,dr,dc);
            for (String s : vpaths) {
                paths.add("v"+ms+s);
            }
        }
        for (int ms = 1; ms+sr <= dr && ms+sc <= dc; ms++) {
            List<String> dpaths = getMazeJumpPath(sr+ms,sc+ms,dr,dc);
            for (String s : dpaths) {
                paths.add("d"+ms+s);
            }
        }
        return paths;
    }
    private static List<String> getMazePath(int sr,int sc,int dr ,int dc) {
        if(sr == dr && sc == dc) {
            List<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        List<String> hpaths = new ArrayList<>();
        List<String> vpaths = new ArrayList<>();
        List<String> paths = new ArrayList<>();
        if(sc < dc) {
            hpaths = getMazePath(sr,sc+1,dr,dc);
        }
        if(sr < dr) {
            vpaths = getMazePath(sr+1,sc,dr,dc);
        }
        for (String s : hpaths) {
            paths.add("h"+s);
        }
        for (String s : vpaths) {
            paths.add("v"+s);
        }
        return paths;
    }
    private static List<String> getStairPath(int n) {
        if(n == 0) {
            List<String> list = new ArrayList<>();
            list.add("");
            return list;
        } else if(n < 0) {
            List<String> list = new ArrayList<>();
            return list;
        }
        List<String> path1 = getStairPath(n-1);
        List<String> path2 = getStairPath(n-2);
        List<String> path3 = getStairPath(n-3);
        List<String> list = new ArrayList<>();
        for (String s : path1) {
            list.add(1 + s);
        }
        for (String s : path2) {
            list.add(2 + s);
        }
        for (String s : path3) {
            list.add(3 + s);
        }
        return list;
    }
    private static String getKeyValue(int idx){
        String[] a = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
        return a[idx];
    }
    private static List<String> getKeyPad(String str) {
        if(str.length() == 0) {
            List<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        String ch = str.substring(0,1);
        String ss = str.substring(1);
        List<String> res = getKeyPad(ss);
        List<String> list = new ArrayList<>();
        String pad = getKeyValue(Integer.parseInt(ch));
        for (int i = 0; i < pad.length(); i++) {
            char c = pad.charAt(i);
            for (String s : res) {
                list.add(c + s);
            }
        }
        return list;
    }
    private static List<String> getSeq(String str) {
        if(str.length() == 0) {
            List<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        char ch = str.charAt(0);
        String ss = str.substring(1);
        List<String> res = getSeq(ss);
        List<String> list = new ArrayList<>();
        for (String s : res) {
            list.add(s);
        }
        for (String s : res) {
            list.add(ch + s);
        }
        return list;
    }
    private static void find(int[] a,int idx,int x) {
        if(idx == a.length) return;
        if(a[idx] == x){
            System.out.println(idx);
        }
        find(a,idx+1,x);
    }
    private static boolean isPrime(int num) {
        for (int i = 2; i * i < num; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
    private static int factorial(int n) {
        int val = 1;
        for (int i = 2; i <= n; i++) {
            val *= i;
        }
        return val;
    }

    private static boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;

        while (i < j) {
            if(str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
