package backtrackingwithrecursion;

import java.util.Scanner;

public class CombinationUsingPermutation2 {
    private static void solution(boolean[] boxes,int ci,int ti,int lb) {
        if(ci > ti) {
            for (int i = 0; i < boxes.length; i++) {
                if(boxes[i]) {
                    System.out.print("i");
                } else {
                    System.out.print("-");
                }
            }
            System.out.println();
            return;
        }
        for (int i = lb + 1; i < boxes.length; i++) {
            if(boxes[i] == false) {
                boxes[i] = true;
                solution(boxes,ci+1,ti,i);
                boxes[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int boxes = scn.nextInt();
        int items = scn.nextInt();
        solution(new boolean[boxes],1,items,-1);
    }
}
