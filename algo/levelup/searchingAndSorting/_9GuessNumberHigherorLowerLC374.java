import java.util.*;
import java.io.*;

public class _9GuessNumberHigherorLowerLC374 {

  public static int guessNumber(int n) {
    int lo = 1;
    int hi = n;
    
    while(lo <= hi) {
        int mid = lo + (hi - lo) / 2;
        int num = guess(mid);
        if(num == 0) {
            return mid;
        } else if(num == -1) {
            hi = mid - 1;
        } else {
            lo = mid + 1;
        }
    }
    return -1;
  }

  static int pn = 0; //picked number
  public static int guess(int val) {
    if (val == pn) {
      return 0;
    }
    else if (val < pn) {
      return 1;
    }
    else {
      return -1;
    }
  }

  public static void solve(int n, int pick) {
    pn = pick;
    System.out.println(guessNumber(n));
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int pick = scn.nextInt();

    solve(n, pick);
  }
}