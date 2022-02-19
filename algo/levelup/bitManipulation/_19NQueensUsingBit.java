import java.io.*;
import java.util.*;

public class _19NQueensUsingBit {

private static boolean isQueenSafe(int i, int j, int cmask, int dmask, int admask, int n) {
        // column check
        int indx = j;
        if((cmask & (1 << indx)) != 0) {
            // in cmask, jth bit is ON, it means jth column is occupied
            return false;
        }

        // diagonal check
        indx = j - i + n - 1;
        if((dmask & (1 << indx)) != 0) {
            // in cmask, jth bit is ON, it means jth column is occupied
            return false;
        }
        // antidiagonal check
        indx = i + j;
        if((admask & (1 << indx)) != 0) {
            // in cmask, jth bit is ON, it means jth column is occupied
            return false;
        }

        return true;
    }
    
  public static void solution(boolean[][] board, int r, int cols, int ndiag, int rdiag, String asf) {
    // board is not required, we can solve this without board
        int n = board.length;
        if(r == n) {
            System.out.println(asf + ".");
            // System.out.println("yes");
            return;
        }

        for(int c = 0; c < board.length; c++) {
            if(isQueenSafe(r, c, cols, ndiag, rdiag, n) == true) {
                // place 
                board[r][c] = true;

                cols ^= (1 << c);
                ndiag ^= (1 << (c - r + n - 1));
                rdiag ^= (1 << (r + c));

                // call to next row
                solution(board, r + 1, cols, ndiag, rdiag, asf + r + "-" + c + ", ");
                // unplace

                cols ^= (1 << c);
                ndiag ^= (1 << (c - r + n - 1));
                rdiag ^= (1 << (r + c));
                board[r][c] = false;
            }
        }
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    boolean[][] board = new boolean[n][n];
    int cols = 0;
    int ndiag = 0;
    int rdiag = 0;
    solution(board, 0, cols, ndiag, rdiag, "");
  }

}