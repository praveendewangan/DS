package practice.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _8OrganizeString {
    //  O(n),O(k)   
    public String reorganizeString(String S) {
        Map<Character,Integer> counts = new HashMap<>();
        for(char ch : S.toCharArray()){
            counts.put(ch,counts.getOrDefault(ch,0)+1);
        }
        
        PriorityQueue<Character> q = new PriorityQueue<>(
            (a,b) -> counts.get(b) - counts.get(a));
        q.addAll(counts.keySet());
        
        StringBuilder sb = new StringBuilder();
        while(q.size() > 1){
            char cur = q.remove();
            char next = q.remove();
            sb.append(cur).append(next);
            
            counts.put(cur,counts.get(cur) - 1);
            counts.put(next,counts.get(next) - 1);
            
            if(counts.get(cur) > 0){
                q.add(cur);
            }
            
            if(counts.get(next) > 0){
                q.add(next);
            }
        }
        if(q.size() > 0) {
            char last = q.remove();
            if(counts.get(last) > 1){
                return "";
            } else {
                sb.append(last);
            }
        }
        return sb.toString();
    }
}
