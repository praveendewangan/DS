package practice.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _35PrintAnagramTogether {
    public List<List<String>> Anagrams(String[] string_list) {
        
        Map<Map<Character,Integer>,List<String>> bmap = new HashMap<>();
        
        for(String str : string_list){
            Map<Character,Integer> mp = new HashMap<>();
            for(char ch : str.toCharArray()){
                mp.put(ch,mp.getOrDefault(ch,0)+1);
            }
            
            if(bmap.containsKey(mp)) {
                List<String> list = bmap.get(mp);
                list.add(str);
                bmap.put(mp,list);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                bmap.put(mp,list);
            }
        }
        List<List<String>> list = new ArrayList<>();
        
        for(List<String> l : bmap.values()){
            list.add(l);
        }
        return list;
        
    }
}
