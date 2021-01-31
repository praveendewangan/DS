package practice.arrays;

public class _33MinimumSwapsKTogether {
    public static int minSwap (int a[], int n, int x) {
        
        int good = 0;
        for(int i=0; i < n;i++) {
            if(a[i] <= x) good++;
        }
        int bad = 0;
        for(int i=0;i < good;i++) {
            if(a[i] > x) bad++;
        }
        int ans = bad;
        for(int i=0, j=good;j<a.length;i++,j++){
            if(a[i] > x) bad--;
            
            if(a[j] > x) bad++;
            
            ans = Math.min(ans,bad);
        }
        return ans;
    }
}
