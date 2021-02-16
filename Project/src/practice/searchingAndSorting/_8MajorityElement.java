package practice.searchingAndSorting;

import java.util.HashMap;
import java.util.Map;

public class _8MajorityElement {
    // O(n),O(n) 
    static int majorityElement(int a[], int size)
    {
        Map<Integer,Integer> hm = new HashMap<>();
        for(int val : a) {
            hm.put(val,hm.getOrDefault(val,0)+1);
        }
        int count = size/2;
        for(Map.Entry<Integer,Integer> entry : hm.entrySet()){
            if(entry.getValue() > count){
                return entry.getKey();
            }
        }
        return -1;
    }
}
