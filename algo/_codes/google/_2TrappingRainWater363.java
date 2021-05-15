public class _2TrappingRainWater363 {
    // LC - 42
    // Input: [0,1,0,2,1,0,1,3,2,1,2,1]
    // Output: 6
    public int trapRainWater(int[] heights) {
        int len = heights.length;
        if(len == 0) return len;
        int[] l = new int[len];
        l[0] = heights[0];
        for(int i = 1; i < len; i++){
            l[i] = Math.max(l[i-1],heights[i]);
        }
        int[] r = new int[len];
        r[len - 1] = heights[len - 1];
        for(int i = len - 2; i >= 0; i--){
            r[i] = Math.max(r[i+1],heights[i]);
        }
        int sum = 0;
        for(int i = 0; i < len; i++) {
            int min = Math.min(l[i],r[i]);
            sum += min - heights[i];
        }
        return sum;
    }
}
