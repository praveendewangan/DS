import java.io.*;
import java.util.*;

public class _7QueenPermutation2BoxChooses {

    public static void queensPermutations1(int qpsf, int tq, int row, int col, String asf, boolean[] queens) {
         if(row == tq) {
             if(qpsf == tq) {
                 System.out.println(asf);
                 System.out.println();
             }
             return;
         }
         if(col+1 < tq) {
             for(int i = 0; i < queens.length; i++){
                 if(!queens[i]){
                     queens[i] = true;
                     queensPermutations(qpsf+1,tq,row,col+1,asf+"q"+(i+1)+"\t",queens);
                     queens[i] = false;
                 }
             }
             queensPermutations(qpsf,tq,row,col+1,asf+"-\t",queens);
         } else {
             for(int i = 0; i < queens.length; i++){
                 if(!queens[i]){
                     queens[i] = true;
                     queensPermutations(qpsf+1,tq,row+1,0,asf+"q"+(i+1)+"\n",queens);
                     queens[i] = false;
                 }
             }
             queensPermutations(qpsf,tq,row+1,0,asf+"-\n",queens);
         }
    }

    // Approch 2
     public static void queensPermutations(int qpsf, int tq, int row, int col, String asf, boolean[] queens) {
         if(row == tq) {
             if(qpsf == tq) {
                 System.out.println(asf);
                 System.out.println();
             }
             return;
         }
             for(int i = 0; i < queens.length; i++){
                 if(!queens[i]){
                     queens[i] = true;
                    if(col+1 < tq) {
                        queensPermutations(qpsf+1,tq,row,col+1,asf+"q"+(i+1)+"\t",queens);
                    } else {
                        queensPermutations(qpsf+1,tq,row+1,0,asf+"q"+(i+1)+"\n",queens);
                    }
                     queens[i] = false;
                 }
             }
             if(col+1 < tq) {
                queensPermutations(qpsf,tq,row,col+1,asf+"-\t",queens);
             } else {
                queensPermutations(qpsf,tq,row+1,0,asf+"-\n",queens);
             } 
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] queens = new boolean[n];

        queensPermutations(0, n, 0, 0, "", queens);
    }
}