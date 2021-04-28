package _codes.arrays;

import java.util.Scanner;

public class _12MatrixMultiplication {
    public static void main(String[] args) {
        int[][] a1 = {
                        {1,2,2},
                        {3,1,1},
                        {2,3,0} 
                    };
        int[][] a2 = {
                        {1,2},
                        {3,1},
                        {2,3} 
                    };
        if(a1[0].length != a2.length) {
            System.out.println("Invalid Input");
        }
        multiply(a1,a2);
    }
    private static void multiply(int[][] a1,int[][] a2) {
        int r1 = a1.length;
        int c1 = a1[0].length;
        int r2 = a2.length;
        int c2 = a2[0].length;
        int[][] ans = new int[r1][c2];

        for(int i = 0; i < r1; i++){
            for(int j = 0; j < c2; j++) {
                int sum = 0;
                for(int k = 0; k < c1; k++){
                    sum += a1[i][k] * a2[k][j];
                }
                ans[i][j] = sum;
            }
        }
        display(ans);
    }
    private static void takeInput(int[][] a,Scanner scn) {
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a[0].length; j++) {
                a[i][j] = scn.nextInt();
            }
        }
    }
    
    private static void display(int[][] a) {
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j]+ " ");
            }
            System.out.println();
        }
    }
}
