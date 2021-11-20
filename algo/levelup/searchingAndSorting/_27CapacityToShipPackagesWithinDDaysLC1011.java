import java.util.*;
import java.io.*;

public class _27CapacityToShipPackagesWithinDDaysLC1011 {

  public static int shipWithinDays(int[]arr, int days) {
    int max = Integer.MIN_VALUE;
    int sum = 0;
    for(int val : arr) {
        sum += val;
        max = Math.max(max,val);
    }
    if(arr.length == days) {
        return max;
    }
    int lo = max;
    int hi = sum;
    int ans = 0;
    while(lo <= hi) {
        int mid = lo + (hi - lo) / 2;
        if(isPossible(arr,mid,days)){
            ans = mid;
            hi = mid - 1;
        } else {
            lo = mid + 1;
        }
    }
    return ans;
  }
  
  private static boolean isPossible(int[] arr,int tar,int m) {
      int c = 1;
      int sum = 0;
      for(int val : arr){
          sum += val;
          if(sum > tar) {
              c++;
              sum = val;
          }
      }
      return c <= m;
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int[]arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    int days = scn.nextInt();

    int ans = shipWithinDays(arr, days);
    System.out.println(ans);
  }
}