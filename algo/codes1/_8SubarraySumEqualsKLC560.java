public class _8SubarraySumEqualsKLC560 {
    public int subarraySum(int[] nums, int x) {
        Map<Integer,Integer> mp = new HashMap<>();
        mp.put(0,1);
        int sum = 0;
        int c = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(mp.containsKey(sum-x)) {
                c += mp.get(sum-x); 
            }
            mp.put(sum,mp.getOrDefault(sum,0)+1);
        }
        return c;
    }
    // public int subarraySum(int[] nums, int x) {
    //     int i = 0;
    //     int j = 0;
    //     int c = 0;
    //     int sum = 0;
    //     while(j < nums.length) {
    //          sum += nums[j];
    //         j++;
    //         while(sum > x && i < j) {
    //             sum -= nums[i];
    //             i++;
    //         }
    //         if(sum == x) {
    //             c++;
    //         }
    //     }
    //     return c;
    // }
/*  2. Using Prefix sum array
    public int subarraySum(int[] nums, int x) {
        int c = 0;
        int[] pre = new int[nums.length];
        int total = 0;
        pre[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            pre[i] = pre[i-1] + nums[i];
        }
        for(int i = 0; i < nums.length; i++){
            if(pre[i] == x) {
                c++;
            }
            for(int j = i+1; j < nums.length; j++) {
                if(pre[j] - pre[i] == x){
                    c++;
                }
            }
        }
        return c;
    }*/
    
//     1. Brute force
/*    public int subarraySum(int[] nums, int x) {
        int c = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i; j < nums.length; j++) {
                int sum = 0;
                for(int k = i; k <= j; k++){
                    sum += nums[k];
                }
                if(sum == x) {
                    c++;
                    System.out.println(i + " - " + j);
                }
            }
        }
        return c;
    }
*/

}
