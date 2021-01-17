package backtrackingwithrecursion;

import java.util.Scanner;

public class _7SolveSudoku extends DisplayArray {
    private static void solve(int[][] a,int i,int j) {
        if(i == a.length ) {
            printArray(a);
            return;
        }
        int ni = 0;
        int nj = 0;
        if(j == a[0].length - 1){
            ni = i + 1;
            nj = 0;
        } else {
            ni = i;
            nj = j + 1;
        }
        if (a[i][j] != 0) {
            solve(a,ni,nj);
        } else {
            for (int k = 1; k <= 9; k++) {
                if(isValid(a,i,j,k) == true) {
                    a[i][j] = k;
                    solve(a,ni,nj);
                    a[i][j] = 0;
                }
            }
        }
    }
    private static boolean isValid(int[][] a,int i,int j,int k) {
        for (int l = 0; l < a[0].length; l++) {
            if(a[i][l] == k){
                return false;
            }
        }
        for (int l = 0; l < a.length; l++) {
            if (a[l][j] == k){
                return false;
            }
        }
        int smi = i / 3 * 3;
        int smj = j / 3 * 3;
        for (int l = 0; l < 3; l++) {
            for (int m = 0; m < 3; m++) {
                if(a[smi + l][smj + m] == k) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = scn.nextInt();
            }
        }
//        printArray(a);
        solve(a,0,0);
        System.out.println("############################");
//        printArray(a);

    }
}
