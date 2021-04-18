package practice.searchingAndSorting;

import java.util.Arrays;

public class _18MinNumOfSwapToSortArray2 {
    // O(nlogn),o(n)

    public static class Pair {
        int val;
        int idx;
        Pair(int val,int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
    public int minSwaps(int arr[])
    {
        int n = arr.length;
        Pair[] pairs = new Pair[n];
        for(int i = 0;i<n;i++){
            pairs[i] = new Pair(arr[i],i);
        }
        Arrays.sort(pairs,(a,b) -> {
            if(a.val > b.val){
                return 1;
            } else if(a.val < b.val) {
                return -1;
            } else {
                return 0;
            }
        });
        // int cycle = 0;
        int ans = 0;
        for(int i=0;i<arr.length;i++){
            if(pairs[i].idx == i) {
                continue;
            } else {
                ans++;
                Pair p = pairs[i];
                pairs[i] = pairs[p.idx];
                pairs[p.idx] = p;
                i--;
            }
        }
        return ans;
    }
}
