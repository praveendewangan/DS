
import java.io.*;
import java.util.*;

public class _40KConcatenationLC1191 {

    private static int kadanes(int[] arr) {
        int csum = arr[0];
        int max = csum;
        for(int i = 1; i < arr.length; i++) {
            if(csum < 0) {
                csum = arr[i];
            } else {
                csum += arr[i];
            }
            max = Math.max(csum,max);
        }
        return max;
    }
    private static int kadanesOfTwo(int[] arr) {
        int[] res = new int[arr.length * 2];
         
        for(int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        
        for(int i = 0; i < arr.length; i++) {
            res[i+arr.length] = arr[i];
        }
        return kadanes(res);
    }
    
  public static long solution(int[] arr, int k, long sum) {
    if(k == 1) {
        return kadanes(arr);
    } else if(sum < 0) {
        return kadanesOfTwo(arr);
    } else {
        return kadanesOfTwo(arr) + (k-2) * sum;
    }

  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    long sum = 0;
    for (int i = 0; i < arr.length; i++) {
      arr[i] = scn.nextInt();
      sum += arr[i];
    }
    int k = scn.nextInt();
    System.out.println(solution(arr, k, sum));
  }

}
