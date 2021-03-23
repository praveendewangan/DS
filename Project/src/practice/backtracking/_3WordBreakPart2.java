package practice.backtracking;

import java.util.ArrayList;
import java.util.List;

public class _3WordBreakPart2 {
    // O(n2n),O(n2)
    static List<String> wordBreak(int n, List<String> dict, String s)
    {
        return solve(dict,s,0);
    }
    
    static List<String> solve(List<String> dict,String s,int start) {
        
        List<String> list = new ArrayList<>();
        if(start == s.length()) {
            list.add("");
        }
        for(int end = start+1;end <= s.length();end++){
            String prefix = s.substring(start,end);
            if(dict.contains(prefix)){
                List<String> suffix = solve(dict,s,end);
                for(String str : suffix) {
                    list.add(prefix + (str.equals("") ? "" : " ")+str);
                }
            }
        }
        return list;
    }
}
