package practice.greedy;

import java.util.Arrays;

public class _16MaximizeSumOfArrayIMulI {
    // O(nLogn),O(1)
    int Maximize(int[] arr, int n)
    {
        Arrays.sort(arr);
        int mod = 1000000007;
        
        long ans = 0;
        for(int i=1;i<n;i++) {
            ans = (ans + ((long)arr[i]*i)%mod )%mod;
        }
        return (int) ans;
        
    }  
}
