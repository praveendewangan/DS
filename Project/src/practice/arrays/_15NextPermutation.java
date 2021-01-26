package practice.arrays;

public class _15NextPermutation {
//    Input: nums = [1,2,3]
//    Output: [1,3,2]
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        nextPermutation(nums);
        for(int a : nums){
            System.out.print(a + " ");
        }
    }
    public static void nextPermutation(int[] nums) {
        int len = nums.length;
        int idx = -1;
        for(int i= len-1; i > 0; i--){
            if(nums[i] > nums[i-1]) {
                idx = i;
                break;
            }
        }
        if(idx == -1) {
            reverse(nums,0,len-1);
        } else {
            int prev = idx;
            for(int i=idx+1; i < len; i++){
                if(nums[i] > nums[idx-1] && nums[i] <= nums[prev]){
                    prev = i;
                }
            }
            int temp = nums[idx-1];
            nums[idx-1] = nums[prev];
            nums[prev] = temp;
            reverse(nums,idx,len-1);
        }
    }

    public static int[] reverse(int[] nums,int start,int end) {
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
        return nums;
    }

}
