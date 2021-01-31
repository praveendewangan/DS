import java.util.Arrays;

public class _28TripleSumInArray {
    /** %%%%%%%%%%%%%%%% First Approch %%%%%%%%%%5 */
    boolean find3Numbers(int arr[], int n, int X)
    {
        for(int i=0;i<n-2;i++) {
            for(int j=i+1;j<n-1;j++) {
                for(int k=j+1;k<n;k++) {
                    if(arr[i]+arr[j]+arr[k] == X){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    /** %%%%%%%%%%%%%%%% Second Approch %%%%%%%%%%5 */
    public static int find3Numbers(int arr[], int n, int X) { 
        Arrays.sort(arr);
       for(int i=0;i<n-2;i++) {
           if(twoNumber(X-arr[i],arr,i+1)) {
               return 1;
           }
        }
        return 0;
    }
    public static boolean twoNumber(int x,int[] a,int i) {
        int j = a.length-1;
        while(i < j){
            if(a[i]+a[j] < x){
                i++;
            } else if(a[i] + a[j] > x) {
                j--;
            } else {
                return true;
            }
        }
        return false;
    }
}