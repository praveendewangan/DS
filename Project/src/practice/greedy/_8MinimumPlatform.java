package practice.greedy;

import java.util.Arrays;

public class _8MinimumPlatform {
    // O(nlogn),O(1)
    static int findPlatform(int arr[], int dep[], int n)
    {
        
    	Arrays.sort(arr);
    	Arrays.sort(dep);
        int max_platform = 1;
        int needed_plateform = 1;
        int i = 1;
        int j = 0;
        while(i < n && j < n) {
            if(arr[i] <= dep[j]) {
                i++;
                ++max_platform;
            } else {
                j++;
                --max_platform;
            }
            if(max_platform > needed_plateform) {
                needed_plateform = max_platform;
            }
        }
        return needed_plateform;
        
    }
}
