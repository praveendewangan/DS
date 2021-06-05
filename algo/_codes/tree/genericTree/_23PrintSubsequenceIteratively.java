public class _23PrintSubsequenceIteratively {
    class Pair{
        String ques;
        int state;
        String ans;
        public Pair(String ques,int state,String ans) {
            this.ques = ques;
            this.state = state;
            this.ans = ans;
        }
    }

    public void prinSseq(String str) {
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(str,0,""));
        List<String> list = new ArrayList<>();
        while(!st.empty()) {
            Pair p = st.peek();
            if(p.ques.length() == 0) {
                list.add(p.ans);
                st.pop();
                continue;
            } 
            String roq = p.ques.substring(1);
            char ch = p.ques.charAt(0);
            if(p.state == 0) {
                p.state++;
                st.push(new Pair(roq,0,p.ans + ch + ""));
            } else if(p.state == 1) {
                p.state++;
                st.push(new Pair(roq,0,"-"));
            } else {
                st.pop();
            }
        }
    }
}
