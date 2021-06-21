import java.util.*;
class _15RottingOrangesLC994 {
    class Pair {
        int r;
        int c;
        int t;
        Pair(int r,int c,int t) {
            this.r = r;
            this.c = c;
            this.t = t;
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int fresh = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 2) {
                    q.add(new Pair(i,j,0));
                } else if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if(fresh == 0) return 0;
        int count = 0;
        int[] xdir = {0,1,0,-1};
        int[] ydir = {1,0,-1,0};
        // System.out.println(q.size());
        // boolean[] v = new boolean[grid.length];
        while(q.size() > 0) {
            int len = q.size();
            while(len-- > 0) {
                Pair rm = q.remove();
                count = rm.t;
                for(int d = 0; d < xdir.length;d++){
                    int nr = rm.r + xdir[d];
                    int nc = rm.c + ydir[d];
                    if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        q.add(new Pair(nr,nc,rm.t+1));  
                        fresh--;  
                    }
                }
            }
        }
        // for(int i = 0; i < grid.length; i++){
        //     for(int j = 0; j < grid[0].length; j++) {
        //         if(grid[i][j] == 1) {
        //             return -1;
        //         }
        //     }
        // }
        return fresh == 0 ? count : -1;
    }
}
