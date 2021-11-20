import java.util.*;
import java.io.*;

public class _24FacingTheSun {
  public static int countBuildings(int[]ht) {
    int count = 0;
    int max = Integer.MIN_VALUE;
    for(int val : ht) {
        if(max <= val) {
            count++;
            max = val;
        }
    }
    return count;
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[]ht = new int[n];

    for (int i = 0; i < n; i++) {
      ht[i] = scn.nextInt();
    }

    System.out.println(countBuildings(ht));
  }
}