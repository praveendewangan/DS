package array;

import java.util.Scanner;

public class RoateElementArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int k = scn.nextInt();
        int s = scn.nextInt();
        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] a = new int[n][m];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                a[i][j] = scn.nextInt();
            }
        }
        printArray(a);
        int r = 0;
        int minr = s-1;
        int minc = s-1;
        int maxr = a.length - 1 - s + 1;
        int maxc = a[0].length - 1 - s + 1;
        int iniMinr = minr;
        int iniMinc = minc;
        int iniMaxc = maxc;
        int iniMaxr = maxr;
        int prev = a[minr][minc+1];
        if(minc == maxc && minr == maxr){
            System.out.println("############### NO ROTATION ################");
            System.exit(0);
        }
        while(r < k) {
            for (int i = minr,j=minc; i <= maxr; i++) {
                int temp = a[i][j];
                a[i][j] = prev;
                prev = temp;
            }
            minc++;
            for (int i = maxr,j=minc; j <= maxc; j++) {
                int temp = a[i][j];
                a[i][j] = prev;
                prev = temp;
            }
            maxr--;
            for (int i = maxr,j=maxc; i >= minr; i--) {
                int temp = a[i][j];
                a[i][j] = prev;
                prev = temp;
            }
            maxc--;
            for (int i = minr,j=maxc; j >= minc; j--) {
                int temp = a[i][j];
                a[i][j] = prev;
                prev = temp;
            }
            minr++;
            r++;
            minr = iniMinr;
            minc = iniMinc;
            maxc = iniMaxc;
            maxr = iniMaxr;
            prev = a[minr][minc+1];

        }
        System.out.println("############### ROTATED ARRAY ELEMENT ################");
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


}
