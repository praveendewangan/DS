
// import java.io.*;
import java.util.*;

public class _33SolveSudoku2 {
  public static void display(int[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void solveSudoku(int[][] board, int r, int c) {
      List<Integer> list = new ArrayList<>();
      for(int i = 0; i < board.length; i++) {
          for(int j = 0; j < board[0].length; j++) {
              if(board[i][j] == 0) {
                  int box = board.length * i + j;
                  list.add(box);
              }
          }
      }
      solve(board,list,0);
  }
  private static void solve(int[][] board,List<Integer> list,int idx){
      if(idx == list.size()) {
            display(board);
            return;
        }
      int box = list.get(idx);
      int r = box / board.length;
      int c = box % board.length;
      for(int i = 1; i < 10; i++){
          if (validate(i, board, r, c)) {
              board[r][c] = i;
              solve(board,list,idx+1);
              board[r][c] = 0;
            }
      }
  }

  private static boolean validate(int val, int[][] board, int r, int c) {
    for (int i = 0; i < board.length; i++) {
      if (board[i][c] == val) {
        return false;
      }
    }

    for (int j = 0; j < board[0].length; j++) {
      if (board[r][j] == val) {
        return false;
      }
    }
    int nr = r - (r % 3);
    int nc = c - (c % 3);
    for(int i = 0; i < 3; i++){
        for(int j = 0; j < 3; j++) {
            if(board[nr+i][nc+j] == val) {
                return false;
            }
        }
    }
    return true;

  }
  
  public static void solveSudoku1(int[][] board, int i, int j) {
    if (i == board.length) {
      display(board);
      return;
    }
    int r = 0;
    int c = 0;
    if (j == board[0].length-1) {
      c = 0;
      r = i + 1;
    } else {
      c = j + 1;
      r = i;
    }

    if (board[i][j] != 0) {
      solveSudoku(board, r, c);
    } else {
      for (int val = 1; val <= 9; val++) {
        if (validate(val, board, i, j)) {
          board[i][j] = val;
          solveSudoku(board, r, c);
          board[i][j] = 0;
        }
      }
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int[][] arr = new int[9][9];
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        arr[i][j] = scn.nextInt();
      }
    }

    solveSudoku(arr, 0, 0);
  }
}
