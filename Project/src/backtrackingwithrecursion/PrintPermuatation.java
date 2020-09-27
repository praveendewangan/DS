package backtrackingwithrecursion;


import java.util.Scanner;

public class PrintPermuatation {
    private static void solution(int[] arr,int ci,int ti) {
        if(ci > ti) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]);
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = ci;
                solution(arr,ci+1,ti);
                arr[i] = 0;
            }
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int nbox = scn.nextInt();
        int items = scn.nextInt();
        solution(new int[nbox],1,items);
    }
}
