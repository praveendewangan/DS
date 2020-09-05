package array;

import java.util.Scanner;

public class Rotate180Degree {
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
            System.out.println("########### ARRAY SWAPED ###############");
            printArray(a);

            for (int i = 0; i < a.length; i++) {
                int j = 0;
                int k = a.length - 1;
                while (j < k) {
                    int t = a[j][i];
                    a[j][i] = a[k][i];
                    a[k][i] = t;
                    j++;
                    k--;
                }
            }
        System.out.println("############### ARRAY ROTATED IN 180 DEGREE ################");
        printArray(a);


    }

    private static void printArray(int[][] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println("");
        }
    }

        private static void swapColumn(int[][] a,int index){
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
