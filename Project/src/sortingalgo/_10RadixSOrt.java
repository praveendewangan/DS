package sortingalgo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _10RadixSOrt {

    public static void radixSort(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        int exp = 1;
        while (exp <= max) {
            countSort(arr,exp);
            exp = exp * 10;
        }
    }

    public static void countSort(int[] arr, int exp) {
//        int range = max - min + 1;
        int[] frq = new int[10];
        for (int i = 0; i < arr.length; i++) {
            int idx = arr[i] / exp % 10;
            frq[idx]++;
        }
        for (int i = 1; i < frq.length; i++) {
            frq[i] = frq[i] + frq[i-1];
        }
        int[] ans = new int[arr.length];
        for (int i = arr.length - 1; i >= 0 ; i--) {
            int val = arr[i] / exp % 10;
            int pos = frq[val];
            int idx = pos - 1;
            ans[idx] = arr[i];
            frq[val]--;
        }
        for (int i = 0; i < ans.length; i++) {
            arr[i] = ans[i];
        }
        System.out.print("After sorting on " + exp + " place -> ");
        print(arr);
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine().trim());
        }
        radixSort(arr);
        print(arr);
    }

}
