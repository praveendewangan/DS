package _2dArray;

import java.util.Scanner;

public class _1Array_2D_Print {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
//       Novic solution
        for (int i=0;i < n;i++) {
            for (int j=0;j < m;j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i=0;i < n;i++) {
            for (int j=0;j < m;j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }


    }
}
