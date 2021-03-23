package practice.backtracking;

import java.util.Scanner;

public class _2NQueens {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        boolean[][] chess = new boolean[n][n];
        printQueen(0,n,chess,-1);
    }    
    private static boolean isQueenSafe(boolean[][] arr,int row,int col) {
        for (int i = row,j=col; i >= 0; i--) {
            if(arr[i][j] == true){
                return false;
            }
        }
        for (int i = row,j=col; j >=0; j--) {
            if(arr[i][j] == true){
                return false;
            }
        }
        for (int i = row,j=col; i >= 0 && j >= 0; i--,j--) {
            if(arr[i][j] == true){
                return false;
            }
        }
        for (int i = row,j=col; i >= 0 && j < arr.length; i--,j++) {
            if(arr[i][j] == true){
                return false;
            }
        }
        return true;
    }
    private static void printQueen(int ci,int tb,boolean[][] chess,int lc) {
        if(ci == chess.length){
            for (int i = 0; i < chess.length; i++) {
                for (int j = 0; j < chess[0].length; j++) {
                    if(chess[i][j]) {
                        System.out.print("q\t");
                    } else {
                        System.out.print("-\t");
                    }
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        for (int i = lc+1; i < chess.length * chess.length; i++) {
            int row = i / chess.length;
            int col = i % chess.length;
            if(chess[row][col] == false && isQueenSafe(chess,row,col)==true) {
                chess[row][col] = true;
                printQueen(ci + 1,tb,chess,row * chess.length + col);
                chess[row][col] = false;
            }
        }
    }
    
}
