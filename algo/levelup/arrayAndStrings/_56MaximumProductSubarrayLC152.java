public class _56MaximumProductSubarrayLC152 {
    public int maxProduct(int[] nums) {
        int n = nums.length, res = nums[0], l = 0, r = 0;
        for (int i = 0; i < n; i++) {
            l =  (l == 0 ? 1 : l) * nums[i];
            r =  (r == 0 ? 1 : r) * nums[n - 1 - i];
            res = Math.max(res, Math.max(l, r));
        }
        return res;
        
    }

    // approch 2;
    public int maxProduct1(int[] nums) {
        int prod = 1;
        int res = Integer.MIN_VALUE;

        // left product
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                res = Math.max(res, nums[i]);
                prod = 1; // for identity of product
            } else {
                prod *= nums[i];
                res = Math.max(res, prod);
            }
        }

        // right product
        prod = 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            if(nums[i] == 0) {
                res = Math.max(res, nums[i]);
                prod = 1; // for identity of product
            } else {
                prod *= nums[i];
                res = Math.max(res, prod);
            }
        }
        return res;
    }
}
