public class _8UniquePaths63 {
    
    public int uniquePathsWithObstacles(int[][] grid) {
        return solve(grid);
    }
    private int solve(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        if(grid[0][0] == 1){
            return 0;
        }
        if(r == 1 && c == 1){
            if(grid[0][0] == 1){
                return 0;
            }
            return 1;
        } 
        int row = 0;
        int col = 0;
        int[][] dp = new int[r][c];
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++) {
                if(i == 0 && grid[i][j] == 1){
                    col = 1;
                } else if(j == 0 && grid[i][j] == 1) {
                    row = 1;
                } else if(i == 0 && grid[i][j] != 1 && col == 0){
                    dp[i][j] = 1;
                } else if(j == 0 && grid[i][j] != 1 && row == 0) {
                    dp[i][j] = 1;
                } else if(i != 0 && j != 0 && grid[i][j] != 1){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1]; 
                }
            }
        }
        return dp[r-1][c-1]; 
    }
}
