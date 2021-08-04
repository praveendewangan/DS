import java.io.*;
import java.util.*;

public class _28NqueensBranchAndBound {

    static boolean[] cols;
    static boolean[] ndia;
    static boolean[] rdia;
  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    // boolean[][] board = new boolean[n][n];
    cols = new boolean[n];
    ndia = new boolean[2*n-1];
    rdia = new boolean[2*n-1];
    solve(n,0,"");
  }
  private static void solve(int n,int r,String asf) {
      if(r == n) {
          System.out.println(asf+".");
          return;
      }
      
      for(int col = 0; col < n;col++) {
          if(isSafe(n,r,col)) {
            //   Mark
              cols[col] = true;
              ndia[r+col] = true;
              rdia[r-col+n-1] = true;
              
            //   Place
            //   board[r][col] = true;
              solve(n,r+1,asf+r+"-"+col+", ");
            //   Unplace
            //   board[r][col] = false;
              
            //   Unmark
              cols[col] = false;
              ndia[r+col] = false;
              rdia[r-col+n-1] = false;
          }
      }
  }
  
  private static boolean isSafe(int n,int r,int c) {
    //   Safety accross column
      if(cols[c]) {
          return false;
      }
    //   Safety accross normal diagonal
      if(ndia[r+c]) {
          return false;
      }
    //   Safety accross reverse diagonal
      if(rdia[r-c+n-1]) {
          return false;
      }
      return true;
  }

}