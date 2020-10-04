package backtrackingwithrecursion;

import java.util.Scanner;

public class QueenCombination2 {
    private static void solution(int ci,int tb,boolean[][] chess,String asf,int lb) {
        if(ci == tb){
            for (int i = 0; i < chess.length; i++) {
                for (int j = 0; j < chess[0].length; j++) {
                    if(chess[i][j]) {
                        System.out.print(asf + "q\t");
                    } else {
                        System.out.print(asf + "-\t");
                    }
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        for (int i = lb + 1; i < chess.length; i++) {
            for (int j = 0; j < chess[0].length; j++) {
                if(!chess[i][j]){
                    chess[i][j] = true;
                    solution(ci+1,tb,chess,asf,i);
                    chess[i][j] = false;
                }
            }
        }
    }
    private static void solution2(int ci,int tb,boolean[][] chess,String asf,int lb) {
        if(ci == tb){
            for (int i = 0; i < chess.length; i++) {
                for (int j = 0; j < chess[0].length; j++) {
                    if(chess[i][j]) {
                        System.out.print(asf + "q\t");
                    } else {
                        System.out.print(asf + "-\t");
                    }
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        for (int cell = lb + 1; cell < chess.length * chess.length; cell++) {
            int row = cell / chess.length;
            int col = cell % chess.length;

            chess[row][col] = true;
            solution2(ci+1,tb,chess,asf,cell);
            chess[row][col] = false;
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
//        solution(0,n,new boolean[n][n],"",-1);
        solution2(0,n,new boolean[n][n],"",-1);
    }
}
