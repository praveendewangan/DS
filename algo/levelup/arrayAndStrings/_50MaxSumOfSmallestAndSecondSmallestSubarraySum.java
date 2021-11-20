public class _50MaxSumOfSmallestAndSecondSmallestSubarraySum {
    public static long pairWithMaxSum(long arr[], long N)
    {
        long max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length - 1; i++) {
            max = Math.max(max, arr[i] + arr[i + 1]);
        }
        return max;
    }    
}
