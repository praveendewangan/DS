package array;

import java.util.Scanner;

public class Array_matrix_mul {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int m1 = sc.nextInt();
        int[][] a1 = new int[n1][m1];
        for (int i=0;i < n1;i++) {
            for (int j=0;j < m1;j++) {
                a1[i][j] = sc.nextInt();
            }
        }
        int n2 = sc.nextInt();
        int m2 = sc.nextInt();
        if(m1 != m2) {
            System.out.println("Can not multiply!!");
            System.exit(0);
        }
        int[][] a2 = new int[n2][m2];
        for (int i=0;i < n2;i++) {
            for (int j=0;j < m2;j++) {
                a2[i][j] = sc.nextInt();
            }
        }
        int[][] arr = new int[n1][m2];
        for (int i=0;i<n1;i++) {
            for (int j=0;j<m2;j++){
                int v = 0;
                    for (int k=0;k<m1;k++) {
                        v += a1[i][k] * a2[k][i];
                    }
                arr[i][j] = v;
            }
        }

        for (int i=0;i < n1;i++) {
            for (int j=0;j < m1;j++) {
                System.out.print(a1[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("---------------------");

        for (int i=0;i < n2;i++) {
            for (int j=0;j < m2;j++) {
                System.out.print(a2[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("---------------------");
        for (int i=0;i < n1;i++) {
            for (int j=0;j < m2;j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

    }


}
