import java.io.*;
import java.util.*;

public class _11NQueensPermutation2dAs1dQueenChooses {

    public static boolean IsQueenSafe(int[][] chess, int row, int col) {
        for(int j = col; j >= 0; j--){
            if(chess[row][j] != 0) return false;
        }
        for(int j = col; j < chess[0].length; j++){
            if(chess[row][j] != 0) return false;
        }
        
        for(int i = row; i >= 0; i--){
            if(chess[i][col] != 0) return false;
        }
        
        for(int i = row; i < chess.length; i++){
            if(chess[i][col] != 0) return false;
        }
        
        for(int i = row,j=col; i >= 0 && j >= 0; i--,j--){
            if(chess[i][j] != 0) return false;
        }
        
        for(int i = row,j=col; i < chess.length && j < chess[0].length; i++,j++){
            if(chess[i][j] != 0) return false;
        }
        
        for(int i = row,j=col; i >= 0 && j < chess[0].length; i--,j++){
            if(chess[i][j] != 0) return false;
        }
        for(int i = row,j=col; i < chess.length && j >= 0; i++,j--){
            if(chess[i][j] != 0) return false;
        }
        return true;
    }

    public static void nqueens(int qpsf, int tq, int[][] chess) {
        if(qpsf == tq) {
            for(int i = 0; i < chess.length; i++){
                for(int j = 0; j < chess[0].length; j++) {
                    if(chess[i][j] == 0) {
                        System.out.print("-\t");
                    } else {
                        System.out.print("q"+(chess[i][j])+"\t");
                    }
                }
                System.out.print("\n");
            }
                System.out.print("\n");
            return;
        }
        for(int b = 0; b < chess.length * chess[0].length; b++){
            int r = b / chess.length;
            int c = b % chess[0].length;
            if(IsQueenSafe(chess,r,c)) {
                chess[r][c] = qpsf+1;
                nqueens(qpsf+1,tq,chess);
                chess[r][c] = 0;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] chess = new int[n][n];

        nqueens(0, n, chess);
    }
}