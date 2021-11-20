class _9LargestNoAtleastTwiceOfOtherLC747 {
    public int dominantIndex(int[] nums) {
        // if(nums.length == 1) return 0;
        int idx = -1;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        
        for(int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if(max1 < val) {
                max2 = max1;
                max1 = val;
                idx = i;
            } else if(max2 < val) {
                max2 = val;
            }
        }
        if(max1 >= 2*max2) {
            return idx;
        }
        return -1;
    }
}