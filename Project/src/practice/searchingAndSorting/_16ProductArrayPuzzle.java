package practice.searchingAndSorting;

public class _16ProductArrayPuzzle {
    // O(n^2),O(1)
    public static long[] productExceptSelf(int arr[], int n) 
	{ 
        
        long[] a = new long[n];
        for(int i = 0; i < n; i++){
            long total = 1;
            for(int j = 0 ;j < n; j++){
                if(j == i) { 
                    continue;
                }
                total = (long)(total * ((long) arr[j])); 
            }
            a[i] = total;
        }
        return a;
	} 
}
