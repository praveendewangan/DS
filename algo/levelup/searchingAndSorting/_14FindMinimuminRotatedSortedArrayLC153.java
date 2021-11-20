import java.util.*;

public class _14FindMinimuminRotatedSortedArrayLC153 {
    // approch 1
    public static int findMinimum(int[]arr) {
        int lo = 0;
        int hi = arr.length - 1;

        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if(arr[mid] < arr[hi]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return arr[hi];
    }
    // approch 2
    public static int findMinimum1(int[]arr) {
        int lo = 0;
        int hi = arr.length-1;
        if(arr[lo] <= arr[hi]) {
            return arr[lo];
        }
        while(lo <= hi) {
            int mid = lo + (hi-lo) / 2;
            if(mid-1 >= 0 && arr[mid] < arr[mid-1]) {
                return arr[mid];
            } else if(mid + 1 < arr.length && arr[mid] > arr[mid+1]) {
                return arr[mid+1];
            }if(arr[lo] <= arr[mid]) {
                lo = mid + 1;
            } else if(arr[mid] <= arr[hi]) {
                hi = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]arr = new int[n];
        for(int i = 0 ; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int ans = findMinimum(arr);
        System.out.println(ans);
    }
}