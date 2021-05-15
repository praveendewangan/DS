public class _1DecodeString575 {
    // LC - 394
    // Input: S = 3[2[ad]3[pf]]xyz
    // Output: "adadpfpfpfadadpfpfpfadadpfpfpfxyz"
    public String expressionExpand(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        Stack<String> st = new Stack<>();
        Stack<Integer> nums = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '['){
                st.push(getStr(ch));
            } else if(ch >= '0' && ch <= '9'){
                StringBuilder sb = new StringBuilder();
                sb.append(getStr(ch));
                while(i + 1 < s.length() && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9'){
                        sb.append(getStr(s.charAt(i + 1)));
                        i++;
                }
                nums.push(Integer.parseInt(sb.toString()));
            } else if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')){
                StringBuilder sb = new StringBuilder();
                sb.append(getStr(ch));
                while(i + 1 < s.length() 
                    && (s.charAt(i + 1) >= 'a' && s.charAt(i + 1) <= 'z')
                    && (s.charAt(i + 1) >= 'A' && s.charAt(i + 1) <= 'Z')){
                        sb.append(getStr(s.charAt(i + 1)));
                        i++;
                }
                st.push(sb.toString());
            } else if(ch == ']'){
                Stack<String> temp = new Stack<>();
                while(!st.empty() && !st.peek().equals("[")) {
                    temp.push(st.pop());
                }
                st.pop();
                StringBuilder sb = new StringBuilder();
                while(!temp.empty()) {
                    sb.append(temp.pop());
                }
                int n = nums.pop();
                String str = sb.toString();
                sb = new StringBuilder();
                for(int x = 1; x <= n; x++) {
                    sb.append(str);
                }
                st.push(sb.toString());
            }
        }
        Stack<String> temp = new Stack<>();
        while(!st.empty()) {
            temp.push(st.pop());
        }
        StringBuilder sb = new StringBuilder();
        while(!temp.empty()) {
            sb.append(temp.pop());
        }
        return sb.toString();
    }
    private String getStr(char ch) {
        return String.valueOf(ch);
    }
}
