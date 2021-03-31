package practice.stackAndQueue;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class _32FirstNonRepeatingCharacterInStream {
    // O(n),O(n)
    public String FirstNonRepeating(String A)
    {
        int len = A.length();
        StringBuilder sb = new StringBuilder();
        Map<Character,Integer> hm = new HashMap<>();
        Queue<Character> q = new ArrayDeque<>();
        for(int i=0;i<len;i++){
            char ch = A.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
            if(hm.get(ch) == 1) {
                q.add(ch);
            }
            while(!q.isEmpty()){
                int count = hm.get(q.peek());
                if(count == 1) {
                    break;
                } else {
                    q.remove();
                }
            }
            if(q.isEmpty()){
                sb.append("#");
            } else {
                sb.append(q.peek()+"");
            }
        }
        return sb.toString();
    }
}
