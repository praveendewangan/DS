package practice.greedy;

import java.util.Arrays;

public class _15MaximizeSumOfArrayAfterKNegation {
    // O(nlogn),O(1)
    public static void main(String[] args) {
        int a[] = { -2, 0, 5, -1, 2 };//{ -1, 0 };//{-1, -1, -2, 4, 3};
        int n = a.length;
        System.out.println(solve(a, n,4));
    }
    private static int solve(int[] arr,int n,int k) {
        int sum = 0;
        Arrays.sort(arr);
        int i = 0;
        for(;i < k;i++) {
            if(i == n-1){
                break;
            } else if(arr[i] < 0) {
                arr[i] = -arr[i];
            } else {
                break;
            }
        }
        if((k-i)%2 != 0) {
            arr[i] = -arr[i];
        }
        for(int val : arr) {
            sum += val;
        }
        return sum;
  
    }
}
