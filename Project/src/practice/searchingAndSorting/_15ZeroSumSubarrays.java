package practice.searchingAndSorting;

import java.util.HashMap;
import java.util.Map;

public class _15ZeroSumSubarrays {
    // O(n),O(n)
    public static int findSubarray(int[] arr ,int n) 
    {
        Map<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);
        int sum = 0;
        int count = 0;
        for(int i = 0; i < n; i++){
            sum += arr[i];
            if(hm.containsKey(sum)){
                count += hm.get(sum);
                hm.put(sum,hm.get(sum)+1);
            } else {
                hm.put(sum,1);
            }
        }
        return count;
    }
}
