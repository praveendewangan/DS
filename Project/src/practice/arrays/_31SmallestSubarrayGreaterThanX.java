package practice.arrays;

public class _31SmallestSubarrayGreaterThanX {
    public static long sb(long a[], long n, long x) {
        // Arrays.sort(a);
        int i = 0;
        int j = 0;
        long sum = 0;
        int count = Integer.MAX_VALUE;
        while(j < n) {
            while(sum <= x && j < a.length) {
                sum += a[j++];
            }
            while(sum > x && i < n) {
                if(j - i < count) {
                    count = j-i;
                }
                
                sum -= a[i++];
            }
        }
        return count;
    }
}
