import java.io.*;
import java.util.*;

public class _3NQueens2 {

    public static void main(String[] args) throws Exception {
        // Scanner scn = new Scanner(System.in);
        int n = 4;
        int[][] chess = new int[n][n];
        printNQueens(chess,0,0,0,"");
    }

    public static void printNQueens(int[][] board, int r,int c,int qsf, String asf) {
        if(sr == board.length) {
            if(qpsf == board.length)
                System.out.println(asf + ".");
            return;
        }

        if(sc + 1 < board[0].length) { // next column is valid
            // yes + isvalid 
            if(isValid(board, sr, sc) == true) {
                board[sr][sc] = 1;
                nqueen(board, sr + 1, 0, qpsf + 1, asf + sr + "-" + sc + ", ");
                board[sr][sc] = 0;
            }
            // no call
            nqueen(board, sr, sc + 1, qpsf, asf);
        } else { // next column is not valid
            // yes + isvalid
            if(isValid(board, sr, sc) == true) {
                board[sr][sc] = 1;
                nqueen(board, sr + 1, 0, qpsf + 1, asf + sr + "-" + sc + ", ");
                board[sr][sc] = 0;
            }
            // no call
            nqueen(board, sr + 1, 0, qpsf, asf);            
        } 
    }
    private static boolean isValid(int[][] a,int row,int col) {
        for(int i = 0; i < a.length; i++){
            if(a[i][col] > 0){
                return false;
            }
        }
        for(int i = 0; i < a[0].length; i++){
            if(a[row][i] > 0){
                return false;
            }
        }
        for(int i = row, j = col; i >= 0 && j >= 0; i-- , j--){
            if(a[i][j] > 0){
                return false;
            }
        }
        
        for(int i = row, j = col; i >= 0 && j < a[0].length; i-- , j++){
            if(a[i][j] > 0){
                return false;
            }
        }
        
        
        return true;
    }
}
