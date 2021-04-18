package practice.arrays;

import java.util.HashMap;
import java.util.Map;

public class _18CountSubarraySum {
    public static void main(String[] args) {

        System.out.println(getPairsCount(new int[]{1,5,7,1},4,6));
    }

    static int getPairsCount(int[] arr, int n, int k) {
        int ans = 0;
        Map<Integer,Integer> hm = new HashMap<>();
        // hm.put(0,1);
        for(int val : arr) {
            hm.put(val,hm.getOrDefault(val,0)+1);
        }
        for(int val : arr){
            if(hm.containsKey(k - val)){
                ans += hm.get(k - val);
            }
            // (val - val) this pair should not be considered 
            if(k - val == val) {
                ans--;
            }
        }
        return ans/2;
    }
}
