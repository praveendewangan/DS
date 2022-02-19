import java.io.*;
import java.util.*;

public class _8AllRepeatingExceptOne {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0 ; i < n; i++){
      arr[i] = scn.nextInt();
    }
    System.out.println(nonRepeatingNum(arr));
    
  }
  private static int nonRepeatingNum(int[] arr) {
        int res = 0;
        for(int val : arr) {
            res = (res ^ val);
        }
        return res;
    }

}