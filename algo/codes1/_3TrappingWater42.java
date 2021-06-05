public class _3TrappingWater42 {
    public int trap(int[] heights) {
        int n = heights.length;
        if(n == 0 || n == 1 || n == 2) {
            return 0;
        }
        int[] left = new int[n];
        left[0] = heights[0];
        int[] right = new int[n];
        right[n-1] = heights[n-1];
        
        for(int i = 1; i < n;i++) {
            left[i] = Math.max(left[i-1],heights[i]);
            right[n-i-1] = Math.max(right[n-i],heights[n-i-1]);
        }
        
        int water = 0;
        for(int i=0; i < n; i++) {
            water += Math.min(left[i],right[i]) - heights[i];
        }
        return water;
    }

}
