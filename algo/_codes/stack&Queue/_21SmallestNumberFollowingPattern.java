public class _21SmallestNumberFollowingPattern {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        solve(str);
    }

    private static void solve(String str) {
        Stack<Integer> st = new Stack<>();
        int count = 1;
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == 'd') {
                st.push(count++);
            } else {
                st.push(count++);
                while(!st.empty()) {
                    System.out.print(st.pop());
                }
            }
        }
        st.push(count);
        while(!st.empty()) {
            System.out.print(st.pop());
        }
        System.out.println();

    }
}
