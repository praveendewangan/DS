package practice.arrays;

import java.util.HashMap;
import java.util.Map;

public class _18CountSubarraySum {
    public static void main(String[] args) {

        System.out.println(getPairsCount(new int[]{1,5,7,1},4,6));
    }
    static int getPairsCount(int[] arr, int n, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);
        for(int i=0;i<n;i++){
            sum += arr[i];

            if(sum == k){
                count++;
            }
            if(hm.containsKey(sum-k)){
                count += hm.get(sum-k);
            }
            hm.put(sum,hm.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
