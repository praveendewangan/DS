package backtrackingwithrecursion;

import java.util.Scanner;

public class QueenPermutation1 {
    private static void solution(int cq,int tq,int[][] chess) {
        if(cq == tq){
            for (int i = 0; i < chess.length; i++) {
                for (int j = 0; j < chess[0].length; j++) {
                    if(chess[i][j] == 0) {
                        System.out.print("-\t");
                    } else {
                        System.out.print("q"+chess[i][j]+"\t");
                    }
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[0].length; j++) {
                if(chess[i][j] == 0){
                    chess[i][j] = cq + 1;
                    solution(cq + 1,tq,chess);
                    chess[i][j] = 0;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] arr = new int[n][n];
        solution(0,n,arr);
    }
}
