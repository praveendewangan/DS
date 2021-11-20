import java.util.*;

public class _18FirstMissingPositiveLC41 {


  //~~~~~~~~~~~~~~~User's Section~~~~~~~~~~~~~~~~~
  public static int firstMissingPositive(int[] arr) {
    // step 1. Mark elements which are out of range and manage presence of one
    boolean one = false;
    int n = arr.length;
    for(int i=0; i < n; i++){
        if(arr[i] == 1) {
            one = true;
        }
        if(arr[i] < 1 || n < arr[i]) {
            arr[i] = 1;
        }
    }
    if(!one) return 1;
    // step 2. Map elemnts with index
    for(int i = 0; i < n; i++){
        int idx = Math.abs(arr[i]);
        arr[idx-1] = -Math.abs(arr[idx-1]);
    }
    // step 3. Find the missing +ve number
    // if element is +ve that means index + 1 is missing
    for(int i = 0; i < n; i++) {
        if(arr[i] > 0) {
            return i+1;
        }
    }
    return n + 1;
  }

  //~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    int res = firstMissingPositive(arr);
    System.out.println(res);
  }
}