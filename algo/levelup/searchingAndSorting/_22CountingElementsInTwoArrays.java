import java.util.*;
import java.io.*;

public class _22CountingElementsInTwoArrays {

  public static int[] find(int[]arr1, int[]arr2) {
    Arrays.sort(arr2);
    int[] ans = new int[arr1.length];
    for(int i=0; i < arr1.length; i++){
        ans[i] = findLastIndex(arr1[i],arr2) + 1;
    }
    return ans;
  }
  
  private static int findLastIndex(int val,int[] arr) {
      int lo = 0;
      int hi = arr.length-1;
      int idx = 0;
      
      while(lo <= hi){
          int mid = lo + (hi-lo) / 2;
          
          if(arr[mid] <= val) {
              idx = mid;
              lo = mid + 1;
          } else {
              hi = mid - 1;
          }
      }
      return lo-1;
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);

    int n1 = scn.nextInt();
    int[]a = new int[n1];

    for (int i = 0; i < n1; i++) {
      a[i] = scn.nextInt();
    }

    int n2 = scn.nextInt();
    int[]b = new int[n2];

    for (int i = 0; i < n2; i++) {
      b[i] = scn.nextInt();
    }

    int[]ans = find(a, b);

    for (int val : ans) {
      System.out.print(val + " ");
    }
  }
}