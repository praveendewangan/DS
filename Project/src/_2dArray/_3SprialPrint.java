package _2dArray;

import java.util.Scanner;

public class _3SprialPrint {
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
        int total = n*m;
        int count = 0;
        int minr = 0;
        int minc = 0;
        int maxr = a.length - 1;
        int maxc = a[0].length - 1;

        while (count < total) {
            for (int i = minr,j = minc; i <= maxr && count < total; i++) {
                System.out.print(a[i][j]+"\t");
                count++;
            }
            minc++;

            for (int i = maxr,j = minc; j <= maxc && count < total; j++) {
                System.out.print(a[i][j]+"\t");
                count++;
            }
            maxr--;

            for (int i = maxr , j = maxc; i >= minr && count < total; i--) {
                System.out.print(a[i][j]+"\t");
                count++;
            }
            maxc--;

            for (int i = minr,j = maxc; j >= minc && count < total; j--) {
                System.out.print(a[i][j]+"\t");
                count++;
            }
            minr++;
        }
    }
}
