package sortingalgo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _11SortDates {
    public static void sortDates(String[] arr) {
        countSort(arr,1000000,100,32);
        countSort(arr,10000,100,13);
        countSort(arr,1,10000,2501);
    }

    public static void countSort(String[] arr,int div, int mod, int range) {

        String[] ans = new String[arr.length];
        int[] frq = new int[range];
        for (int i = 0; i < arr.length; i++) {
            int idx = Integer.parseInt(arr[i],10) / div % mod;
            frq[idx]++;
        }
        for (int i = 1; i < frq.length; i++) {
            frq[i] = frq[i] + frq[i-1];
        }
        for (int i = arr.length - 1; i >= 0 ; i--) {
            int val = Integer.parseInt(arr[i],10) / div % mod;
            int pos = frq[val];
            int idx = pos - 1;
            ans[idx] = arr[i];
            frq[val]--;
        }
        for (int i = 0; i < ans.length; i++) {
            arr[i] = ans[i];
        }
//        System.out.print("After sorting on " + div + " place -> ");
//        print(arr);
    }

    public static void print(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine().trim();
            arr[i] = str;
        }
        sortDates(arr);
        print(arr);
    }

}
