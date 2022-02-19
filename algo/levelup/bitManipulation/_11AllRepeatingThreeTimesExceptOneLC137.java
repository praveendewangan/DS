import java.io.*;
import java.util.*;

public class _11AllRepeatingThreeTimesExceptOneLC137 {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0 ; i < n; i++){
      arr[i] = scn.nextInt();
    }
    solution(arr);
  }

  public static void solution(int[] arr){
   int res = 0;
    for(int i = 0; i < 32; i++) {
        int count = 0;
        int bm = (1 << i);
        for(int val : arr) {
            // check if ith bit is ON or OFF in val
            if((val & bm) == bm) {
                count++;
            }
        }
        if(count % 3 == 1) {
            // ON ith bit in result
            res = (res | bm);
        }
    }   
    System.out.println(res);
   
  }
  // generic
  public static void repeatThriceExceptOne2(int[] arr){
    int n3p0 = (~0); // all bits are 1
    int n3p1 = 0; // all bits are 0
    int n3p2 = 0; // all bits are 0

    for(int val : arr) {
        int cn3p1 = (n3p0 & val);
        int cn3p2 = (n3p1 & val);
        int cn3p3 = (n3p2 & val);

        // off in same bit and on in next one
        // cn3p1 -> OFF in n3p0 and ON in n3p1
        n3p0 = (n3p0 & (~cn3p1));
        n3p1 = (n3p1 | cn3p1);
        
        // cn3p2 -> OFF in n3p1 and ON in n3p2
        n3p1 = (n3p1 & (~cn3p2));
        n3p2 = (n3p2 | cn3p2);
        
        // cn3p3 -> OFF in n3p2 and ON in n3p0
        n3p2 = (n3p2 & (~cn3p3));
        n3p0 = (n3p0 | cn3p3);
    }
    System.out.println(n3p1);
}
}