import java.util.*;
import java.io.*;

public class _23CountZerosXorPairs {
  public static int countPairs(int[]arr) {
    Map<Integer,Integer> map = new HashMap<>();
    for(int val : arr) {
        map.put(val,map.getOrDefault(val,0)+1);
    }
    int ans = 0;
    for(int key : map.keySet()) {
        int f = map.get(key);
        ans += (f * (f-1)) / 2;
    }
    return ans;
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[]arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    System.out.println(countPairs(arr));
  }
}