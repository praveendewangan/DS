package practice.string;

import java.util.HashMap;
import java.util.Map;

public class _28SecondMostRepeatedSequence {
    //  O(n),O(n);
    String secFrequent(String arr[], int N)
    {
        Map<String,Integer> hm =  new HashMap<>();
        int c1 = 0;
        String s1 = null;
        int c2 = 0;
        String s2 = null;
        for(String s : arr){
            if(hm.containsKey(s)){
               hm.put(s,hm.get(s)+1); 
            } else {
               hm.put(s,1);
            }
        }
        for(Map.Entry<String,Integer> entry : hm.entrySet()){
            if(entry.getValue() > c1){
                c2 = c1;
                s2 = s1; 
                c1 = entry.getValue();
                s1 = entry.getKey();
            } else if(entry.getValue() > c2){
                c2 = entry.getValue();
                s2 = entry.getKey();
            }
        }
        return s2;
        
    } 
}
