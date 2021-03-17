package practice.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _17MaximizeSumOfAbsolteDiffValue {
    // O(nlogn),O(n)
    public int maxSumDiff(int[] arr,int n) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(arr);
        int sum = 0;
        for(int i=0;i<n/2;i++) {
            list.add(arr[i]);
            list.add(arr[n-i-1]);
        }
        if(n%2 != 0) {
            list.add(arr[n/2]);
        }
        for(int i=0;i<n-1;i++) {
            sum += Math.abs(list.get(i) - list.get(i+1));
        }
        sum += Math.abs(list.get(n-1) - list.get(0));
        return sum;
    }
}
