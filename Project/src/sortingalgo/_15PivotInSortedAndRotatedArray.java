package sortingalgo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _15PivotInSortedAndRotatedArray {

    public static int findPivot(int[] arr) {
        int lo = 0;
        int hi = arr.length-1;
        while (lo < hi) {
            int mid = ( lo + hi ) / 2;
            if(arr[mid] < arr[hi]){
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return arr[lo];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine().trim());
        }
        int pivot = findPivot(arr);
        System.out.println(pivot);
    }

}
