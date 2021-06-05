import java.util.*;

public class _2LargestBand128 {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        
        for(int i=0; i < n; i++){
            set.add(nums[i]);
        }
        int count = 0;
        for(int i = 0; i < n; i++){
            int val = nums[i] - 1;
            if(!set.contains(val)){
                int c = 1;
                val = nums[i] + 1;
                while(set.contains(val)){
                    c++;
                    val++;
                }
                count = Math.max(count,c);
            }
        }
        return count;
    }

}
