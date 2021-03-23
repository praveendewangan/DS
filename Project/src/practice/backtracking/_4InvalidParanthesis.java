package practice.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class _4InvalidParanthesis {
    Map<String,Integer> hm = new HashMap<>();
    Map<String,List<String>> res = new HashMap<>();
    public List<String> removeInvalidParentheses(String s) {
        int n =  getMin(s);
        return solve(s,n);
    }
    
    public List<String> solve(String s,int n) {
        if(res.containsKey(s)) {
            return res.get(s);
        }
        List<String> list = new ArrayList<>();
        if(n == 0) {
            int mn = getMin(s);
            if(mn == 0) {
                list.add(s);
                return list;
            }
        }
        for(int i=0;i<s.length();i++) {
            String left = s.substring(0,i);
            String right = s.substring(i+1);
            List<String> slist = solve(left+right,n-1);
            for(String str : slist) {
                if(!list.contains(str)) {
                    list.add(str);
                }
            }
        }
        res.put(s,list);
        return list;
    }
    
    public int getMin(String s) {
        if(hm.containsKey(s)) {
            return hm.get(s);
        }
        Stack<Character> st = new Stack<>();
        
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                st.push(ch);
            } else if(ch == ')') {
                if(st.size() == 0) {
                    st.push(ch);
                } else if(st.peek() == '(') {
                    st.pop();
                } else if(st.peek() == ')'){
                    st.push(ch);
                }
            }
        }
        hm.put(s,st.size());
        return st.size();
    }
}
