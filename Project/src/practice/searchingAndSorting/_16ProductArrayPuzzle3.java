package practice.searchingAndSorting;

public class _16ProductArrayPuzzle3 {
    // O(n),O(1)
    public static long[] productExceptSelf(int arr[], int n) 
	{ 
        if(arr.length == 1) {
            long[] a = new long[n];
            a[0] = (long) arr[0];
            return a;
        }
        long[] res = new long[n];
        res[0] = (long) arr[0];
        for(int i = 1; i < n; i++){
            res[i] = res[i-1] * ((long) arr[i]);
        }
        long product = 1;
        for(int i=n-1;i>=0;i--){
            if(i == n-1){
                res[i] = res[i-1];
                product = (long) arr[i];
            } else if(i == 0) {
                res[i] = product;
            } else {
                res[i] = product * res[i-1];
                product = product * ((long) arr[i]);
            }
        }
        return res;
	} 
}
