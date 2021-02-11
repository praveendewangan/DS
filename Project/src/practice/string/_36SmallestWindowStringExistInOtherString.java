package practice.string;

import java.util.HashMap;
import java.util.Map;

public class _36SmallestWindowStringExistInOtherString {
    public static String smallestWindow(String S, String P){
        Map<Character,Integer> map2 = new HashMap<>();
        
        for(char ch : P.toCharArray()){
            map2.put(ch,map2.getOrDefault(ch,0)+1);
        }
        int mct = 0;
        int dmct =P.length();
        int i=-1;
        int j=-1;
        String ans = "";
        Map<Character,Integer> map1 = new HashMap<>();
        while(true){
            boolean f1 = false;
            boolean f2 = false;
            
            while(i < S.length()-1 && mct < dmct) {
                i++;
                char ch = S.charAt(i);
                map1.put(ch,map1.getOrDefault(ch,0)+1);
                
                if(map1.getOrDefault(ch,0) <= map2.getOrDefault(ch,0)){
                    mct++;
                }
                f1 = true;
            }
            
            while(j < i && mct == dmct){
                String pans = S.substring(j+1,i+1);
                if(ans.length() == 0 || ans.length() > pans.length()) {
                    ans = pans;
                }
                j++;
                char ch = S.charAt(j);
                if(map1.get(ch) == 1){
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
        return ans.length() == 0 ? "-1" : ans;
    }
}
