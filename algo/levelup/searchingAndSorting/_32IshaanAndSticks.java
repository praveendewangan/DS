import java.util.*;
import java.io.*;

public class _32IshaanAndSticks {

  public static ArrayList<Integer>  solve(int[]arr) {
    Map<Integer,Integer> map = new HashMap<>();
    int ans = -1;
    int count = -1;
    for(int val : arr) {
        map.put(val,map.getOrDefault(val,0)+1);
    }
    for(int key : map.keySet()) {
        int val = map.get(key);
        if(val >= 4){
            int num = val / 4;
            if(key*key > ans) {
                ans = key*key;
                count = num;
            }
        }
    }
    ArrayList<Integer> list = new ArrayList<>();
    list.add(ans);
    list.add(count);
    return list;
  }

  public static void main(String[]args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[]arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    ArrayList<Integer>ans = solve(arr);

    for (int val : ans) {
      System.out.print(val + " ");
    }
  }
}