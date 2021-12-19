public class _15TrappingRainWaterLC42 {
    // Approch 1 - using dual iteration
    public int trap(int[] height) {
        int owater = 0; // overall water
        int maxIndx = 0;
        int rwater = 0; // runnning water
        for(int i = 0; i < height.length; i++) {
            if(height[maxIndx] <= height[i]) {
                owater += rwater;
                rwater = 0;
                maxIndx = i;
            }
            rwater += height[maxIndx] - height[i];
        }
        rwater = 0;
        int rmaxIndx = height.length - 1;
        // some amount of water is not safe
        for(int i = height.length - 1; i >= maxIndx; i--) {
            if(height[rmaxIndx] <= height[i]) {
                owater += rwater;
                rwater = 0;
                rmaxIndx = i;
            }
            rwater += height[rmaxIndx] - height[i];
        }
        return owater;    
    }

    // method 2. Two Pointer Approach
    public int trap3(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int lmax = 0;
        int rmax = 0;

        int water = 0;
        while(left < right) {
            lmax = Math.max(lmax, height[left]);
            rmax = Math.max(rmax, height[right]);

            if(lmax < rmax) {
                water += lmax - height[left];
                left++;
            } else {
                water += rmax - height[right];
                right--;
            }
        }
        return water;
    }
}
