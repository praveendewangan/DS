import java.io.*;
import java.util.*;

public class _23SumOfBitDifferencesOfAllPairs {

  public static long sumOfBitDifference(int[] arr){
        long res = 0;
        for(int i = 0; i < 32; i++) {
            long count0 = 0;
            long count1 = 0;
            for(int val : arr) {
                // check if ith bit is ON in val or not
                int bm = (1 << i);
                if((val & bm) != 0) {
                    // bit is ON
                    count1++;
                } else {
                    // bit is OFF
                    count0++;
                }
            }
            res += count0 * count1 * 2;
        }
        return res;
    }

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0 ; i < arr.length; i++){
      arr[i] = scn.nextInt();
    }
    System.out.println(sumOfBitDifference(arr));
  }

}