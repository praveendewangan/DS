package array;

import java.util.Scanner;

public class Roate90degree {
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
        printArray(a);

        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a[0].length; j++) {
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
//            swap(a,i);
        }
        System.out.println("############### ROTATED ARRAY ################");
        printArray(a);

        for (int i = 0; i < a.length; i++) {
            int j = 0;
            int k = a[0].length - 1;
            while (j < k) {
                int t = a[i][k];
                a[i][k] = a[i][j];
                a[i][j] = t;
                j++;
                k--;
            }
        }
        System.out.println("############### ARRAY ROTATED IN 90 DEGREE ################");
        printArray(a);
        //  for different size of array
/*        int[][] b = new int[m][n];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                b[j][i] = a[i][j];
            }
        }

        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                System.out.print(b[i][j] + "\t");
            }
        }*/

    }

    private static void printArray(int[][] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println("");
        }
    }

    private static void swap(int[][] a,int index){
        int i = 0;
        int j = a[0].length - 1;
        int temp = 0;
        while (i < j) {
            temp = a[index][j];
            a[index][j] = a[index][i];
            a[index][i] = temp;
            i++;
            j--;
        }
    }
}
