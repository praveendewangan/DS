public class _58MaxAverageSubarrayLC643 {
    public double findMaxAverage(int[] nums, int k) {
        if(nums.length == 1) {
            return nums[0] * 1.0;
        }
        double avg = 0.0;
        double sum = 0.0;
        for(int i = 0; i < k; i++) {
            sum += nums[i];
        }    
        avg = sum / k;
        int i = 0;
        int j = k;
        while(j < nums.length) {
            sum += nums[j];
            sum -= nums[i];
            avg = Math.max(avg, sum*1.0 / k);
            j++;
            i++;
        }
        return avg;
    }

    // LC 643
    public double findMaxAverage1(int[] nums, int k) {
        if(nums.length == 1) {
            return nums[0] * 1.0;
        }
        double avg = 0.0;
        double sum = 0.0;
        for(int i = 0; i < k; i++) {
            sum += nums[i];
        }    
        avg = sum / k;
        int i = 0;
        int j = k;
        while(j < nums.length) {
            sum += nums[j];
            sum -= nums[i];
            avg = Math.max(avg, sum*1.0 / k);
            j++;
            i++;
        }
        return avg;
    }    
}
