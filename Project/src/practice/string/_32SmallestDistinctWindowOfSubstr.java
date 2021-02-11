package practice.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _32SmallestDistinctWindowOfSubstr {
    public String findSubString( String str) {
        StringBuilder sb = new StringBuilder();
        Set<Character> set = new HashSet<>();
        for(char ch : str.toCharArray()){
            if(!set.contains(ch)){
                set.add(ch);
                sb.append(ch);
            }
        }
        // System.out.println(sb.toString());
        String pat = sb.toString();
        Map<Character,Integer> map2 = new HashMap<>();
        for(char ch : pat.toCharArray()){
            map2.put(ch,map2.getOrDefault(ch,0)+1);
        }
        int mct = 0;
        int dmct = pat.length();// if already pattern is given
        Map<Character,Integer> map1 = new HashMap<>();
        int i = -1;
        int j = -1;
        String ans = "";
        while(true) {
            boolean f1 = false;
            boolean f2 = false;
            while(i < str.length()-1 && mct < dmct) {
                i++;
                char ch = str.charAt(i);
                map1.put(ch,map1.getOrDefault(ch,0)+1);
                
                if(map1.getOrDefault(ch,0) <= map2.getOrDefault(ch,0)){
                    mct++;
                }
                f1 = true;
            } 
            
            while(j < i && mct == dmct) {
                String pans = str.substring(j+1,i+1);
                if(ans.length() == 0 || ans.length() > pans.length()){
                    ans = pans;
                }
                j++;
                char ch = str.charAt(j);
                if(map1.get(ch) == 1) {
                    map1.remove(ch);
                } else {
                    map1.put(ch,map1.get(ch)-1);
                }
                if(map1.getOrDefault(ch,0) < map2.getOrDefault(ch,0)){
                    mct--;
                }
                f2 = true;
            }
            if(!f1 && !f2) break;
        }
        
        // System.out.println(ans);
        return ans;
    }
}
