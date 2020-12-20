package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _12DifferenceOfTwoArrays {
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
        int[] diff = a.length > b.length ? a : b;
        int i = n - 1;
        int j = m - 1;
        int k = diff.length - 1;
        int add = 0;
        int c = 0;
        while (k >= 0) {
            int d = b[j] + c;
            if(i >= 0) {
                if(d > a[i]) {
                    d = d - a[i];
                } else {
                    c = -1;
                    d = d + 10 - a[i];
                }
            }
            diff[k] = d;
            i--;
            j--;
            k--;
        }

        if(c > 0) {
            System.out.println(c);
        }
        for (int val : diff) {
            if(val != 0) {
                System.out.println(val);
            }
        }
    }
}
