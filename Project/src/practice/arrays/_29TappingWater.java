package practice.arrays;

public class _29TappingWater {
    /* %%%%%%%%%%%%%%%%% First Approtch %%%%%%%%%%% */
    static int trappingWater(int arr[], int n) { 
        
        int[] l = new int[n];
        int[] r = new int[n];
        l[0] = arr[0];
        r[n-1] = arr[n-1];
        for(int i=1;i<n;i++){
            if(l[i-1] > arr[i]){
                l[i] = l[i-1];
            } else {
                l[i] = arr[i];
            }
        }
        for(int i=n-2;i>=0;i--){
            if(r[i+1] > arr[i]){
                r[i] = r[i+1];
            } else {
                r[i] = arr[i];
            }
        }
        int sum = 0;
        for(int i=0;i<n;i++){
            sum += Math.min(l[i],r[i]) - arr[i];
        }
        return sum;
    } 

    /* %%%%%%%%%%%%%%%% Second Approch %%%%%%%%%%% */
    static int trappingWater1(int a[], int n) { 
        
        int l = 0;
        int r = n-1;
        int lm = 0;
        int rm = 0;
        int sum = 0;
        while(l <= r) {
            if(a[l] <= a[r]){
                if(a[l] >= lm) {
                    lm = a[l];
                } else {
                    sum += lm - a[l];
                }
                l++;
            } else {
                if(a[r] >= rm) {
                    rm = a[r];
                } else {
                    sum += rm - a[r];
                }
                r--;
            }
        }
        return sum;
    } 
}
