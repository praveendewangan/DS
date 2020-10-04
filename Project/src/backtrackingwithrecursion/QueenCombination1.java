package backtrackingwithrecursion;

import java.util.Scanner;

public class QueenCombination1 {
    private static void solution(int cb,int tb,int row,int col,String asf) {
        if (row == tb) {
            if (cb == tb)
            System.out.println(asf);
            return;
        }
        int nr = 0;
        int nc = 0;
        String yasf = "";
        String nasf = "";
        if(col == tb-1) {
            nr = row + 1;
            nc = 0;
            yasf = asf+"q\n";
            nasf = asf+"-\n";
        } else {
            nr = row;
            nc = col + 1;
            yasf = asf+"q";
            nasf = asf+"-";
        }
        solution(cb+1,tb,nr,nc,yasf);
        solution(cb,tb,nr,nc,nasf);
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        solution(0,n,0,0,"");
    }
}
