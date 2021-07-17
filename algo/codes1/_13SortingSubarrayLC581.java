import java.util.Arrays;

public class _13SortingSubarrayLC581 {

    // Approch 1 O(nlogn)
    private int[] sort(int[] nums) {
        int[] a = new int[nums.length];
        for(int i =0; i<nums.length; i++) {
            a[i] = nums[i];
        }
        Arrays.sort(a);
        int start = -1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != a[i]) {
                start = i;
                break;
            }
        }
        int end = -1;
        for(int i = nums.length-1; i >= 0; i--) {
            if(nums[i] != a[i]) {
                end = i;
                break;
            }
        }
        return new int[]{start,end};
    }

    // Approch 2 O(n)
    private int[] sort1(int[] nums) {
        int max = Integer.MIN_VALUE;
        int end = -1;
        for(int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            if(nums[i] < max) {
                end = i;
            }
        }
        int start = -1;
        int min = Integer.MAX_VALUE;
        for(int i = nums.length-1; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            if(nums[i] > min) {
                start = i;
            }
        }
        return new int[]{start,end};
    }
}
