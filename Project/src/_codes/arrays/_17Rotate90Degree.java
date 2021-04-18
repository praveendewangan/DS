package _codes.arrays;

import java.util.Scanner;

public class _17Rotate90Degree {
    public static void main(String[] args) throws Exception {
        // Scanner scn = new Scanner(System.in);
        // int r = scn.nextInt();
        // int[][] a = new int[r][r];
        // takeInput(a,scn);
        int[][] a = {
            {11,12,13,14},
            {21,22,23,24},
            {31,32,33,34},
            {41,42,43,44}
        };
        rotate90Deg(a);
        display(a);
    }
    private static void rotate90Deg(int[][] a) {
        transpose(a);
        for(int i = 0;i < a.length; i++){
            swap(a[i]);
        }
    }
    private static void transpose(int[][] a) {
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[0].length; j++) {
                if(j < i){
                    int t = a[i][j];
                    a[i][j] = a[j][i];
                    a[j][i] = t;
                }
            }
        }
    }
    private static void swap(int[] a) {
        int i = 0;
        int j = a.length-1;
        while(i < j) {
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
            i++;
            j--;
        }
    }
    private static void takeInput(int[][] a,Scanner scn) {
         for(int i = 0; i < a.length; i++) {
             for(int j = 0; j < a[0].length; j++) {
                 a[i][j] = scn.nextInt();
             }
         }
    }
    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
