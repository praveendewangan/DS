package array;

import java.util.Scanner;

public class HalfDiagonalPrint {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        String[][] a = new String[n][n];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                a[i][j] = scn.next();
            }
        }
        print(a);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0,k=i; k < a.length; j++,k++) {
                System.out.println(a[j][k]);
            }

        }

    }

    public static void print(String[][] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j]+"\t");
            }
            System.out.println("");
        }
    }
}
