import java.util.*;

class _24SimplifyPathLC71 {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        String[] s = path.split("/");
        for(String str : s) {
            if(!st.isEmpty() && str.equals("..")) {
                st.pop();
            } else if(!str.equals(".") && !str.equals("") && !str.equals("..")) {
                st.push(str);
            }
        }
        if(st.isEmpty()) {
            return "/";
        }
        Stack<String> temp = new Stack<>();
        while(!st.isEmpty()) {
            temp.push(st.pop());
        }
        while(!temp.isEmpty()) {
            sb.append("/").append(temp.pop());
        }
        return sb.toString();
    }
}