import java.util.*;
public class _3NumberofDistinctIslandsLNC860 {
    int[] xdir = {-1,0,1,0};
    int[] ydir = {0,1,0,-1};
    String[] dir = {"t","l","d","r"};
    public int numberofDistinctIslands(int[][] grid) {
        HashSet<String> set = new HashSet<>();
        for(int i=0; i < grid.length; i++) {
            for(int j=0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder("x");
                    distinctCount(grid,i,j,sb);
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }
    private void distinctCount(int[][] grid,int x,int y,StringBuilder sb) {
        grid[x][y] = 0;
        for(int d=0; d < 4; d++) {
            int r = x + xdir[d];
            int c = y + ydir[d];
            if(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length 
            && grid[r][c] == 1) {
                sb.append(dir[d]);
                distinctCount(grid,r,c,sb);
            }
        }
        sb.append("z");
    }
}
