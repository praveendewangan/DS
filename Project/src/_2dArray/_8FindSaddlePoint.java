package _2dArray;

import java.util.Scanner;

/*
*  Saddle point - element is least in its row and max in its column
* */
public class _8FindSaddlePoint {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] a = new int[n][m];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                a[i][j] = scn.nextInt();
            }
        }
        print(a);
        int index = 0;
        for (int i = 0; i < a.length; i++) {
            int num = 0;
            for (int j = 1; j < a.length; j++) {
                if (a[i][j] < a[i][num]) {
                    num = j;
                }
            }
            boolean flag = true;
            for (int j = 0; j < a.length ; j++) {
                if(a[j][num] > a[i][num]){
                    flag = false;
                    break;
                }
            }
            if(flag == true) {
                System.out.println("#### ::: SADDLE POINT :: "+a[i][num]);
                return;
            }
        }
        System.out.println("#### ::: SINVALID INPUT");
    }
    private static void print(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j]+"\t");
            }
            System.out.println("");
        }
    }
}
