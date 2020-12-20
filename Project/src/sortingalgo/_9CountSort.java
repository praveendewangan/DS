package sortingalgo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _9CountSort {
    public static void countSort(int[] arr, int min, int max) {
        int range = max - min + 1;
        int[] frq = new int[range];
        for (int i = 0; i < arr.length; i++) {
            int idx = arr[i] - min;
            frq[idx]++;
        }
        for (int i = 1; i < frq.length; i++) {
            frq[i] = frq[i] + frq[i-1];
        }
        int[] ans = new int[arr.length];
        for (int i = arr.length - 1; i >= 0 ; i--) {
            int val = arr[i];
            int pos = frq[val - min];
            int idx = pos - 1;
            ans[idx] = arr[i];
            frq[val-min]--;
        }
        for (int i = 0; i < ans.length; i++) {
            arr[i] = ans[i];
        }
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine().trim());
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        countSort(arr,min,max);
        print(arr);
    }

}
