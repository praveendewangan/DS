public class _57MinimumSizeSubarraySumLC209 {
    public int minSubArrayLen(int target, int[] nums) {
        int left  = 0;
        int sum = 0;
        int len = Integer.MAX_VALUE;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] >= target) return 1;
            
            sum += nums[i];
            while(sum >= target) {
                len = Math.min(len,i - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        
        return len == Integer.MAX_VALUE ? 0 : len;
    }
}
