import java.util.*;

public class _39MaximumSubarrayLC53 {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int csum = 0;
        int omax =Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(csum < 0){
                csum = nums[i];
            } else {
                csum += nums[i];
            }
            omax = Math.max(omax,csum);
        }
        return omax;
    }
    public int maxSubArray2(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int max = nums[0];
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            
                sum += nums[i];
                max = Math.max(max,sum);
            if(sum < 0) {
                sum = 0;
            } 
        }
        return max;
        
    }
    public int maxSubArray1(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int max = nums[0];
        for(int i = 0; i < nums.length; i++){
            int sum = 0;
            for(int j = i; j < nums.length; j++){
                sum += nums[j];
                max = Math.max(max,sum);
            }
        }
        return max;
    }    
}
