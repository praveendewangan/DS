public class _4SubArraySort {
    public static int[] subarraySort(int[] nums) {
        int n = nums.length;
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            if(outOfOrder(nums,nums[i],i)){
                smallest = Math.min(smallest,nums[i]);
                largest = Math.max(largest,nums[i]);
            }
        }
        if(smallest == Integer.MAX_VALUE) {
            return new int[]{-1,-1};
        }
        int left = 0;
        while(smallest >= nums[left]) {
            left++;
        }
        int right = n-1;
        while(largest <= nums[right]) {
            right--;
        }
        return new int[]{left,right};
    }

    private static boolean outOfOrder(int[] a,int x,int  i) {
        if(i == 0) {
            return x > a[1];
        }
        if(i == a.length - 1) {
            return x < a[i-1];
        }
        return x > a[i+1] || x < a[i-1];
    }
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,8,6,7,9,10,11};
        int[] arr = subarraySort(a);
        System.out.println(arr[0] + " - " + arr[1]);
    }
}
