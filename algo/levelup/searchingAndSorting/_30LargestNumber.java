import java.util.*;
import java.io.*;

public class _30LargestNumber {

  public static String largestNumber(int[]nums) {
      String[] arr = new String[nums.length];
      for(int i=0; i < nums.length; i++){
          arr[i] = String.valueOf(nums[i]);
      }
    Arrays.sort(arr,(a,b)-> {
       String s1 = ""+a+b; 
       String s2 = ""+b+a;
        return s2.compareTo(s1);
    });
    
    if(nums[0] == 0){
        return "0";
    }
    StringBuilder sb = new StringBuilder(); 
    for(String s : arr){
        sb.append(s);
    }
    return sb.toString();
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[]nums = new int[n];

    for (int i = 0; i < n; i++) {
      nums[i] = scn.nextInt();
    }

    System.out.println(largestNumber(nums));
  }
}