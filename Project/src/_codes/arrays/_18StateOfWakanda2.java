package _codes.arrays;

import java.util.Scanner;

public class _18StateOfWakanda2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] a = new int[n][n];
        takeInput(a,scn);
        // Approtch 1
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(j + i < n){
                    System.out.println(a[j][j+i]);
                }
            }
        }
        // Approtch 2
        for(int diag = 0; diag < a.length; diag++){
            for(int i=0,j=diag; j < a.length;i++,j++){
                System.out.println(a[i][j]);
            }
        }
    }
    private static void takeInput(int[][] a,Scanner scn) {
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a[0].length; j++) {
                a[i][j] = scn.nextInt();
            }
        }
    }   
}
