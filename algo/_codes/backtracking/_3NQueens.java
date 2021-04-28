import java.io.*;
import java.util.*;

public class _3NQueens {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] chess = new int[n][n];
        printNQueens(chess,"",0);
    }

    public static void printNQueens(int[][] chess, String qsf, int row) {
        if(row == chess.length) {
            System.out.println(qsf + ".");
            return;
        }
        
        for(int i = 0; i < chess[0].length; i++){
            if(isValid(chess,row,i)){
                chess[row][i] = 1;
                printNQueens(chess,qsf + row+"-"+i+", ",row+1);
                chess[row][i] = 0;
            }
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
