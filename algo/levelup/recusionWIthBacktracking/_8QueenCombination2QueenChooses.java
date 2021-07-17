import java.io.*;
import java.util.*;

public class Main {

    public static void queensCombinations1(int qpsf, int tq, boolean[][] chess, int i, int j){
        if(qpsf == tq) {
            for(int x = 0; x < chess.length; x++) {
                for(int y = 0; y < chess[0].length; y++) {
                    if(chess[x][y]) {
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
        for(int y = j+1; y < chess[0].length; y++) {
            chess[i][y] = true;
            queensCombinations(qpsf+1,tq,chess,i,y);
            chess[i][y] = false;
        }
        for(int x = i+1; x < chess.length; x++) {
            for(int y = 0; y < chess[0].length; y++) {
                chess[x][y] = true;
                queensCombinations(qpsf+1,tq,chess,x,y);
                chess[x][y] = false;
            }
        }
    }
    

    // Another approch
    public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int i, int j){
        if(qpsf == tq) {
            for(int x = 0; x < chess.length; x++) {
                for(int y = 0; y < chess[0].length; y++) {
                    if(chess[x][y]) {
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
        // for(int y = j+1; y < chess[0].length; y++) {
        //     chess[i][y] = true;
        //     queensCombinations(qpsf+1,tq,chess,i,y);
        //     chess[i][y] = false;
        // }
        for(int x = i; x < chess.length; x++) {
            for(int y = j+1; y < chess[0].length; y++) {
                chess[x][y] = true;
                queensCombinations(qpsf+1,tq,chess,x,y);
                chess[x][y] = false;
            }
            j=-1;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];
        
        queensCombinations(0, n, chess, 0, -1);
    }
}