package practice.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _3WordBreakPart2DP {
    static List<String> wordBreak(int n, List<String> dict, String s)
    {
        Map<Integer,List<String>> mp = new HashMap<>();
        return solve(dict,s,0,mp);
    }
    
    static List<String> solve(List<String> dict,String s,int start,Map<Integer,List<String>> mp) {
        if(mp.containsKey(start)) {
            return mp.get(start);
        }
        List<String> list = new ArrayList<>();
        if(start == s.length()) {
            list.add("");
        }
        for(int end = start+1;end <= s.length();end++){
            String prefix = s.substring(start,end);
            if(dict.contains(prefix)){
                List<String> suffix = solve(dict,s,end,mp);
                for(String str : suffix) {
                    list.add(prefix + (str.equals("") ? "" : " ")+str);
                }
            }
        }
        mp.put(start,list);
        return list;
    }
}
