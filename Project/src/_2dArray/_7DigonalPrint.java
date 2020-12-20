package _2dArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class _7DigonalPrint {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] a = new int[n][n];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                a[i][j] = Integer.parseInt(br.readLine());
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
