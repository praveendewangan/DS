package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class _11SumOfTwoArrays {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        int m = Integer.parseInt(br.readLine());
        int b[] = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(br.readLine());
        }
        int[] sum = a.length > b.length ? a : b;
        int i = n - 1;
        int j = m - 1;
        int k = sum.length - 1;
        int add = 0;
        int c = 0;
        while (k >= 0) {
            int d = c;
            if(i >= 0) {
                d += a[i];
            }
            if(j >= 0) {
                d += b[j];
            }
            c = d / 10;
            d = d % 10;
            sum[k] = d;
            k--;
            j--;
            i--;
        }

        if(c > 0) {
            System.out.println(c);
        }
        for (int l = 0; l < sum.length; l++) {
            System.out.println(sum[l]);
        }

    }
}
