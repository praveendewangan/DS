package sortingalgo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.Arrays;

public class _14TargetSumPair {
    public static void targetSumPair(int[] arr, int target){
        Arrays.sort(arr);
        int li = 0;
        int ri = arr.length - 1;
        while (li <= ri) {
            if(arr[li] + arr[ri] < target) {
                li++;
            } else if(arr[li] + arr[ri] > target) {
                ri--;
            } else {
                System.out.println(arr[li] + ","+arr[ri]);
                li++;
                ri--;
            }
        }

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[] arr = new int[n];
        for(int i = 0 ;i < n; i++){
            arr[i] = Integer.parseInt(br.readLine().trim());
        }
        int target = Integer.parseInt(br.readLine().trim());
        targetSumPair(arr,target);
    }
}
