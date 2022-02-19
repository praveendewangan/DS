// import java.io.*;
import java.util.*;

public class _18SudokuUsingBitManipulation {

  public static void display(int[][] arr){
    for (int ii = 0; ii < arr.length; ii++) {
      for (int jj = 0; jj < arr.length; jj++) {
        System.out.print(arr[ii][jj] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }



    private static boolean isSafeToPlace(int[] rows, int[] cols, int[][] grid, int i, int j, int n) {
        int bm = (1 << n);
        
        // row repitition check
        int rowBitMask = rows[i];
        // check if nth bit is ON in rowBitMask
        if((rowBitMask & bm) != 0) {
            return false;
        }

        // col repitition check
        int colBitMask = cols[j];
        // check if nth bit is ON in rowBitMask
        if((colBitMask & bm) != 0) {
            return false;
        }

        // submatrix repitition check
        int smri = i / 3; // smri -> submatrix row index
        int smci = j / 3; // smci -> submatrix col index

        int smBitMask = grid[smri][smci];
        if((smBitMask & bm) != 0) {
            return false;
        }

        return true;
    }

    private static void OnBitInChecks(int[] rows, int[] cols, int[][] grid, int i, int j, int n) {
        rows[i] = (rows[i] | (1 << n));
        cols[j] = (cols[j] | (1 << n));
        grid[i / 3][j / 3] = (grid[i / 3][j / 3] | (1 << n));
        
        // OR
        /*
        rows[i] ^= (1 << n));
        cols[j] ^= (1 << n));
        grid[i / 3][j / 3] = (1 << n));
        
        */
    }

    private static void OffBitInChecks(int[] rows, int[] cols, int[][] grid, int i, int j, int n) {
        int bm = (1 << n);
        rows[i] = (rows[i] & (~bm));
        cols[j] = (cols[j] & (~bm));
        grid[i / 3][j / 3] = (grid[i / 3][j / 3] & (~bm));
        
        // OR
        /*
        rows[i] ^= (1 << n));
        cols[j] ^= (1 << n));
        grid[i / 3][j / 3] = (1 << n));
        
        */
    }
  public static void solveSudoku(int[][] arr, int[] rows, int[] cols, int[][] grid, int i, int j) {
    // for particular i, j index, we check all 9 possible number to place it at i, j, if it is not occupied
        if(j == arr[0].length) {
            i++;
            j = 0;
        }

        if(i == arr.length) {
            display(arr);
            return;
        }

        if(arr[i][j] != 0) {
            // place is occupied
            solveSudoku(arr, rows, cols, grid, i, j + 1); // try on next cell
        } else {
            for(int num = 1; num <= 9; num++) {
                // check if we can place num at i, j
                if(isSafeToPlace(rows, cols, grid, i, j, num) == true) {
                    // place num
                    arr[i][j] = num;
                    OnBitInChecks(rows, cols, grid, i, j, num);
                    // make call to next cell
                    solveSudoku(arr, rows, cols, grid, i, j + 1);
                    // unplace num for backtracking
                    OffBitInChecks(rows, cols, grid, i, j, num);
                    arr[i][j] = 0;
                }
            }
        }
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int[][] arr = new int[9][9];
    int[] rows = new int[9];
    int[] cols = new int[9];
    int[][] grid = new int[3][3];

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        int digit = scn.nextInt();
        arr[i][j] = digit;
        rows[i] |= (1 << digit);
        cols[j] |= (1 << digit);
        grid[i / 3][j / 3] |= (1 << digit);
      }
    }

    solveSudoku(arr, rows, cols, grid, 0, 0);
  }

}