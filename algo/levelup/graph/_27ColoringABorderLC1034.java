import java.util.*;
public class _27ColoringABorderLC1034 {
    int[] xdir = {-1,0,1,0};
    int[] ydir = {0,1,0,-1};
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        dfs(grid,row,col,vis);
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] < 0) {
                    grid[i][j] = color;
                }
            }
        }
        return grid;
    }
    private void dfs(int[][] grid,int x, int y,boolean[][] vis) {
        int val = grid[x][y];
        vis[x][y] = true;
        grid[x][y] *= -1;
        int count = 0;
        for(int d = 0; d < 4; d++) {
            int r = x + xdir[d];
            int c = y + ydir[d];
            
            if(r >= 0 && c >= 0 && r < grid.length && c < grid[0].length) {
                if(grid[r][c] == val || grid[r][c] == -val) {
                    count++;
                }
                
                if(grid[r][c] == val && !vis[r][c] ) {
                    dfs(grid,r,c,vis);
                }
                
            }
        }
        if(count == 4) {
            grid[x][y] *= -1;
        }
    }
}