import java.util.*;

public class _14WiggleSort1 {

    private static void swap(int[] a,int i,int j) {
        int val = a[i];
        a[i] = a[j];
        a[j] = val;
    }
  // ~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~
  public static void wiggleSort(int[] arr) {
    for(int i = 0; i < arr.length-1; i++){
        if(i % 2 == 0) {
            if(arr[i] > arr[i+1]) {
                swap(arr,i,i+1);
            }
        } else {
            if(arr[i] < arr[i+1]) {
                swap(arr,i,i+1);
            }
        }
    }
  }

  // ~~~~~~~~~~~~Input Management~~~~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int n = scn.nextInt();
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    wiggleSort(arr);

    for (int val : arr) {
      System.out.print(val + " ");
    }
    System.out.println();
  }

}
