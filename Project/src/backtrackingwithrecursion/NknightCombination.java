package backtrackingwithrecursion;

import java.util.Scanner;

public class NknightCombination {
    private static boolean isKnightSafe(boolean[][] chess,int row,int col) {
        if (row - 1 >= 0 && col - 2 >= 0 && chess[row - 1][col - 2]) {
            return false;
        }
        if (row - 2 >= 0 && col - 1 >= 0 && chess[row - 2][col - 1]) {
            return false;
        }
        if (row - 2 >= 0 && col + 1 < chess.length && chess[row - 2][col + 1]) {
            return false;
        }
        if (row - 1 >= 0 && col + 2 < chess.length && chess[row - 1][col + 2]) {
            return false;
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
            if(chess[row][col] == false && isKnightSafe(chess,row,col)==true) {
                chess[row][col] = true;
                printQueen(ci + 1,tb,chess,row * chess.length + col);
                chess[row][col] = false;
            }
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        boolean[][] chess = new boolean[n][n];
        printQueen(0,n,chess,-1);
    }
}
