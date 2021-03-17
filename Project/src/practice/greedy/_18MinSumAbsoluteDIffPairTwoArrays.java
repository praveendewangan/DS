package practice.greedy;

import java.util.Arrays;

public class _18MinSumAbsoluteDIffPairTwoArrays {
    // O(nlogn),O(1);
    static long findMinSum(long a[], long b[], long n)
    {
        // Sort both arrays
        Arrays.sort(a);
        Arrays.sort(b);
      
        // Find sum of absolute differences
        long sum = 0 ;
        for (int i = 0; i < n; i++)
            sum = sum + Math.abs(a[i] - b[i]);
      
        return sum;
    }
}
