package backtrackingwithrecursion;

import java.util.Scanner;

public class NQueensPermutation {
    private static boolean isQueenSafe(int[][] arr,int row,int col) {
        for (int i = row,j=col; i >= 0; i--) {
            if(arr[i][j] > 0){
                return false;
            }
        }
        for (int i = row,j=col; i < arr.length; i++) {
            if(arr[i][j] > 0){
                return false;
            }
        }
        for (int i = row,j=col; j >=0; j--) {
            if(arr[i][j] > 0){
                return false;
            }
        }
        for (int i = row,j=col; j < arr.length; j++) {
            if(arr[i][j] > 0){
                return false;
            }
        }
        for (int i = row,j=col; i >= 0 && j >= 0; i--,j--) {
            if(arr[i][j] > 0){
                return false;
            }
        }
        for (int i = row,j=col; i < arr.length && j >= 0; i++,j--) {
            if(arr[i][j] > 0){
                return false;
            }
        }
        for (int i = row,j=col; i >= 0 && j < arr.length; i--,j++) {
            if(arr[i][j] > 0){
                return false;
            }
        }
        for (int i = row,j=col; i < arr.length && j < arr.length; i++,j++) {
            if(arr[i][j] > 0){
                return false;
            }
        }
        return true;
    }
    private static void printQueen(int ci,int tb,int[][] chess) {
        if(ci == chess.length){
            for (int i = 0; i < chess.length; i++) {
                for (int j = 0; j < chess[0].length; j++) {
                    if(chess[i][j] != 0) {
                        System.out.print(chess[i][j]+"\t");
                    } else {
                        System.out.print(chess[i][j]+"\t");
                    }
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < chess.length * chess.length; i++) {
            int row = i / chess.length;
            int col = i % chess.length;
            if(chess[row][col] == 0 && isQueenSafe(chess,row,col)==true) {
                chess[row][col] = ci + 1;
                printQueen(ci + 1,tb,chess);
                chess[row][col] = 0;
            }
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] chess = new int[n][n];
        printQueen(0,n,chess);
    }
}
