import java.util.*;
class _11SwimInRisingWaterLC778 {
    int max = Integer.MAX_VALUE;
    int[] xdir = {0,1,0,-1};
    int[] ydir = {1,0,-1,0};
    public int swimInWater(int[][] grid) {
        int num = grid.length * grid[0].length;
        // int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        bfs(grid,visited,0,0,grid[0][0]);
        // dfs(grid,visited,0,0,grid[0][0]);
        return max;
    }
    private void bfs(int[][] grid,boolean[][] v,int r,int c,int num){
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> a[2] - b[2]);
        pq.add(new int[]{r,c,grid[r][c]});
        
        v[r][c] = true;
        max = Integer.MIN_VALUE;
        while(pq.size() > 0) {
            int[] rm = pq.remove();
            max = Math.max(rm[2],max);
            if(rm[0] == grid.length -1 && rm[1] == grid[0].length-1) break;
            
            for(int d = 0; d < xdir.length;d++) {
                int x = rm[0] + xdir[d];
                int y = rm[1] + ydir[d];
                if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && !v[x][y]) {       
                    
                    v[x][y] = true;
                    pq.add(new int[]{x,y,grid[x][y]});
                }
            }
        }
        
    }
    private void dfs(int[][] grid,boolean[][] v,int r,int c,int num) {
        if(r == grid.length-1 && c == grid[0].length - 1){
            if(max > num){
                max = num;
            }
            return;
        }
        v[r][c] = true;
        for(int d = 0; d < xdir.length;d++) {
            int x = r + xdir[d];
            int y = c + ydir[d];
            if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && !v[x][y]) {
                int temp = num;
                if(num < grid[x][y]){
                    num = grid[x][y];
                }
                dfs(grid,v,x,y,num);
                num = temp;
            }
        }
        
        v[r][c] = false;
    }
}
