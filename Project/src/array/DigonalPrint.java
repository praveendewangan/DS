package array;

import java.util.Scanner;

public class DigonalPrint {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                a[i][j] = scn.nextInt();
            }
        }
        print(a);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0,k=i; k < a.length; j++,k++) {
                System.out.println(a[j][k]);
            }

        }
    }
    private static void print(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.println(a[i][j]+"\t");
            }
        }
    }
}
