import java.util.*;
import java.io.*;

public class _34LeadersInArray {

  public static ArrayList<Integer>  leaders(int[]arr) {
    int max = Integer.MIN_VALUE;
    ArrayList<Integer> list = new ArrayList<>();
    for(int i=arr.length-1; i >= 0; i--){
        if(arr[i] >= max) {
            max = arr[i];
            list.add(arr[i]);
        }
    }
    Collections.reverse(list);
    return list;
  }

  public static void main(String[]args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[]arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    ArrayList<Integer>ans = leaders(arr);

    for (int val : ans) {
      System.out.print(val + " ");
    }
  }
}