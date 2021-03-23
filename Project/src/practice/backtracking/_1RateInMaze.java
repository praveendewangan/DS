package practice.backtracking;

import java.util.ArrayList;

public class _1RateInMaze {
    // O((n^2)^4), O(LX) , L = Length of the path, X = Number of the path
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> list = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];
        solve(m,n,0,0,list,visited,"");
        return list;
    }
    private static void solve(int[][] m,int n,int i,int j,
        ArrayList<String> list,boolean[][] visited,String path) {
        if(i == -1 || i >= n || j >= n || j == -1 || m[i][j] == 0 || visited[i][j]) {
            return;
        } 
        if(i == n-1 && j == n-1) {
            list.add(path);
            return;
        }
        visited[i][j] = true;
        solve(m,n,i+1,j,list,visited,path+"D");
        solve(m,n,i,j-1,list,visited,path+"L");
        solve(m,n,i,j+1,list,visited,path+"R");
        solve(m,n,i-1,j,list,visited,path+"U");
        visited[i][j] = false;
    }
}
