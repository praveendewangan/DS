package graph;

import java.util.Scanner;

public class _6CountNoOfIslands {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n =  scn.nextInt();
        int m =  scn.nextInt();
        int[][] a = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = scn.nextInt();
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(a[i][j] == 0 && !visited[i][j]) {
                    solve(a,i,j,visited);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    private static void solve(int[][] a,int i, int j,boolean[][] visited) {
        if(i < 0 || j < 0 || i >= a.length || j >= a[0].length ||
        a[i][j] == 1 || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        solve(a,i - 1,j,visited);
        solve(a,i,j + 1,visited);
        solve(a,i,j - 1,visited);
        solve(a,i + 1,j,visited);
    }
}
