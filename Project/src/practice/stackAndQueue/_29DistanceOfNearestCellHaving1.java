package practice.stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class _29DistanceOfNearestCellHaving1 {
    public int[][] nearest(int[][] grid)
    {
        if(grid == null || grid.length == 0){
            return grid;
        }
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        
        for(int i=0; i < n;i++) {
            for(int j=0; j < m;j++) {
                if(grid[i][j] == 0) {
                    q.add(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }
        final int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i < size;i++){
                int[] cur = q.poll();
                int curX = cur[0];
                int curY = cur[1];
                for(int[] dir : dirs) {
                    int x = curX + dir[0];
                    int y = curY + dir[1];
                    if(x < 0 || x > n-1 || y < 0 || y > m-1 || visited[x][y]){
                        continue;
                    }
                    grid[x][y] = grid[curX][curY] + 1;
                    q.add(new int[]{x,y});
                    visited[x][y] = true;
                    
                }
            }
        }
        return grid;
    }
}
