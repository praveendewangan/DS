package backtrackingwithrecursion;

import java.util.Scanner;

public class PrintPermutationUsingCombination {
    private static void solution(int cb,int tb,int[] itmes,int ssf,int ts,String asf) {
        if (cb > tb) {
            if (ssf == ts) {
                System.out.println(asf);
            }
            return;
        }
        for (int i = 0; i < itmes.length; i++) {
            if (itmes[i] == 0) {
                itmes[i] = 1;
                solution(cb+1,tb,itmes,ssf+1,ts,asf + (i + 1));
                itmes[i] = 0;
            }
        }
                solution(cb+1,tb,itmes,ssf,ts,asf + 0);
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int boxes = scn.nextInt();
        int itmes = scn.nextInt();
        solution(1,boxes,new int[itmes],0,itmes,"");
    }
}
