import java.util.*;
import java.io.*;

public class _29PunishTheStudents {

  public static boolean shouldPunish(int[]roll, int[]marks, double avg) {
    int swap = 0;
    int n = roll.length;
    
    for(int i= 1; i <= n-1; i++) {
        for(int j = 0; j < n-i; j++) {
            if(roll[j] > roll[j+1]) {
                swap += 2;
                int temp = roll[j+1];
                roll[j+1] = roll[j];
                roll[j] = temp;
            }
        }
    }
    int oldMarks = 0;
    for(int val : marks){
        oldMarks += val;
    }
    int newMarks = oldMarks - swap;
    double navg = newMarks*1.0 / n;
    return navg >= avg;
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int[]roll = new int[n];

    for (int i = 0; i < n; i++) {
      roll[i] = scn.nextInt();
    }

    int[]marks = new int[n];

    for (int i = 0; i < n; i++) {
      marks[i] = scn.nextInt();
    }

    double avg = scn.nextDouble();

    System.out.println(shouldPunish(roll, marks, avg));
  }
}