package practice.backtracking;

import java.util.*;

public class _14PermutationOfString {
    
    public List<String> find_permutation(String S) {
        List<String> list = new ArrayList<>();
        solve(S,list,"");
        return list;
    }
    
    public void solve(String s,List<String> list,String asf) {
        if(s.length() == 0) {
            list.add(asf);
            return;
        }
        
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            String left = s.substring(0,i);
            String right = s.substring(i+1);
            String rest = left + right;
            solve(rest,list,asf+ch);
        }
    }
}
