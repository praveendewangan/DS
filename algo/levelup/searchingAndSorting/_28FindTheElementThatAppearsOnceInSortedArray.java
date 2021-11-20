import java.util.*;
import java.io.*;

public class _28FindTheElementThatAppearsOnceInSortedArray {

  public static int findSingleElement(int[]arr) {
    int lo = 0;
    int n = arr.length;
    int hi = n-1;
    if(n % 2 == 0) {
        return 0;
    }
    while(lo <= hi) {
        int mid = lo + (hi-lo) / 2;
        if(mid+1 < n && arr[mid] == arr[mid+1]){
            if((n-mid) % 2 == 0){
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        } else if(mid > 0 && arr[mid] == arr[mid-1]) {
            if(mid % 2 == 1){
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        } else {
            return arr[mid];
        }
    }
    return -1;
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[]arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    int ans = findSingleElement(arr);
    System.out.println(ans);
  }
}