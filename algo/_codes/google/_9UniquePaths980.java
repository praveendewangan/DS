public class _9UniquePaths980 {
    public int uniquePathsIII(int[][] grid) {
        int zeros = 0;
        int r = 0;
        int c = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0){
                    zeros++;
                }
                if(grid[i][j] == 1){
                    r = i;
                    c = j;
                }
            }
        }
        return solve(grid,r,c,zeros);
    }
    private int solve(int[][] a,int r,int c,int zeros) {
        if(r < 0 || c < 0 || r >= a.length || c >= a[0].length || a[r][c] == -1){
            return 0;
        }
        
        if(a[r][c] == 2){
            return zeros == -1 ? 1 : 0;
        }
        
        a[r][c] = -1;
        zeros--;
        int total = solve(a,r+1,c,zeros)
            + solve(a,r-1,c,zeros)
            + solve(a,r,c+1,zeros)
            + solve(a,r,c-1,zeros);
        zeros++;
        a[r][c] = 0;
        return total;
    }
}
