package practice.searchingAndSorting;

public class _16ProductArrayPuzzle2 {
    // O(n),O(n)
    public static long[] productExceptSelf(int arr[], int n) 
	{ 
        if(arr.length == 1) {
            long[] a = new long[n];
            a[0] = (long) arr[0];
            return a;
        }
        long[] left = new long[n];
        long[] right = new long[n];
        long[] res = new long[n];
        left[0] = (long) arr[0];
        right[n-1] = (long) arr[n-1];
        for(int i = 1; i < n; i++){
            left[i] = left[i-1] * ((long) arr[i]);
        }
        
        for(int i = n-2; i >= 0; i--){
            right[i] = right[i+1] * ((long) arr[i]);
        }
        for(int i=0;i<n;i++){
            if(i == 0) {
                res[i] = right[i+1];
            } else if(i == n-1) {
                res[i] = left[i-1];
            } else {
                res[i] = left[i-1] * right[i+1];
            }
        }
        return res;
	} 
}
