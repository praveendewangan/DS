package bitmanupulation;

import java.util.Scanner;

public class _18NqueensWithBranching {
    private static void solution(boolean[][] b,int row,int cols,int ndig,int rdig,String asf) {
        if(row == b.length) {
            System.out.println(asf);
            return;
        }
        for (int col = 0; col < b.length; col++) {
            if(
                    ((cols & (1 << col)) == 0) &&
                    ((ndig & (1 << (row + col))) == 0) &&
                    ((rdig & (1 << (row - col + b.length - 1))) == 0)
            ){
//                b[row][col] = true;
                cols ^= (1 << col);
                ndig ^= (1 << (row + col));
                rdig ^= (1 << (row - col + b.length - 1));
                solution(b,row + 1,cols,ndig,rdig,asf + row + " - "+col + ", ");
//                b[row][col] = false;
                cols ^= (1 << col);
                ndig ^= (1 << (row + col));
                rdig ^= (1 << (row - col + b.length - 1));
            }
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n =  scn.nextInt();
        boolean[][] b = new boolean[n][n];
        int cols = 0;
        int ndig = 0;
        int rdig = 0;
        solution(b,0,cols,ndig,rdig,"");
    }
}
