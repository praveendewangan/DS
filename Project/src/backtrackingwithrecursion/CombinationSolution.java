package backtrackingwithrecursion;

import java.util.Scanner;

public class CombinationSolution {
    private static void solution(int cb,int tb,int ssf,int ts,String asf) {
        if (cb > tb) {
            if(ssf == ts){
                System.out.println(asf);
            }
            return;
        }
        solution(cb + 1,tb,ssf+1,ts,asf+"i");
        solution(cb + 1,tb,ssf,ts,asf+"-");
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int boxes = scn.nextInt();
        int items = scn.nextInt();
        solution(1,boxes,0,items,"");
    }
}
