package array;

import java.util.Scanner;

public class SnakeArrayPrint {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] a = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[j][i] = scn.nextInt();
            }
        }

        int c = a[0].length;
        int r = a.length;
        for (int i = 0; i < c; i++) {
            if(i%2 == 0) {
                for (int j = 0; j < r; j++) {
                    System.out.print(a[j][i] + "\t");
                }
            } else {
                for (int j = r-1; j >= 0; j--) {
                    System.out.print(a[j][i] + "\t");
                }
            }
        }
    }
}
