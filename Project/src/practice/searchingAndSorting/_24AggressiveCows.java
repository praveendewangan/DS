package practice.searchingAndSorting;

import java.util.Arrays;

public class _24AggressiveCows {
    public static void main(String[] args) {
        int[] barn = new int[]{1,2,8,4,9};
        Arrays.sort(barn);
        int n = barn.length;
        int cows = 3;

        int lo = 0;
        int hi = n;
        int best = 0;
        while(lo <= hi) {
            int mid = (lo + hi + 1) / 2;
            int count = 1;
            int left = 0;
            for(int i=1;i < n && count < cows; i++) {
                if(barn[i] - barn[left] >= mid) {
                    left = i;
                    count++;
                }
            }
            if(count >= cows) {
                best = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        System.out.println(best);
    }
}
