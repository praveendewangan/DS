package _2dArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _6ShellRotate {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(br.readLine());
            }
        }
        int s = Integer.parseInt(br.readLine());
        int r = Integer.parseInt(br.readLine());
        rotateShell(a,s,r);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void rotateShell(int[][] a,int s,int r) {
        int[] oned = fillOneDfromShell(a,s);
        rotate(oned,r);
        fillShellFromOned(a,s,oned);
    }
    public static int[] fillOneDfromShell(int[][] a,int s){
        int minr = s - 1;
        int minc = s - 1;
        int maxr = a.length - s;
        int maxc = a[0].length - s;
        int sz = 2*(maxr - minr + 1) + 2*(maxc - minc + 1) - 4;
        int[] oned = new int[sz];
        int idx = 0;

        for (int i = minr,j = minc; i <= maxr; i++) {
            oned[idx] = a[i][j];
            idx++;
        }

        for (int i = maxr,j = minc + 1; j <= maxc; j++) {
            oned[idx] = a[i][j];
            idx++;
        }

        for (int i = maxr - 1,j = maxc; i >= minr; i--) {
            oned[idx] = a[i][j];
            idx++;
        }

        for (int i = minr,j = maxc - 1; j >= minc + 1; j--) {
            oned[idx] = a[i][j];
            idx++;
        }

        return oned;
    }
    private static void fillShellFromOned(int[][] a, int s,int[] oned) {
        int minr = s - 1;
        int minc = s - 1;
        int maxr = a.length - s;
        int maxc = a[0].length - s;
        int idx = 0;

        for (int i = minr,j = minc; i <= maxr; i++) {
            a[i][j] = oned[idx];
            idx++;
        }

        for (int i = maxr,j = minc + 1; j <= maxc; j++) {
            a[i][j] = oned[idx];
            idx++;
        }

        for (int i = maxr - 1,j = maxc; i >= minr; i--) {
            a[i][j] = oned[idx];
            idx++;
        }

        for (int i = minr,j = maxc - 1; j >= minc + 1; j--) {
            a[i][j] = oned[idx];
            idx++;
        }

    }
    private static void rotate(int a[],int r) {
        r = r % a.length;
        if(r < 0) {
            r += a.length;
        }
        reverse(a,0,a.length-r-1);
        reverse(a,a.length-r,a.length-1);
        reverse(a,0,a.length-1);
    }
    private static void reverse(int[] a,int start,int end) {
        while (start < end) {
            int temp = a[end];
            a[end] = a[start];
            a[start] = temp;
            start++;
            end--;
        }
    }
}
