package practice.backtracking;

public class _5Sudoku {
    static boolean SolveSudoku(int grid[][])
    {
        solve(grid,0,0);
        
        return true;
    }
    static void solve(int[][] grid,int i,int j) {
        if(i == grid.length) {
            printGrid(grid);
            return;
        }
        int ni=0;
        int nj=0;
        if(j == grid[0].length - 1) {
            ni = i+1;
            nj = 0;
        } else {
            nj = j + 1;
            ni = i;
        }
        
        if(grid[i][j] != 0){
            solve(grid,ni,nj);
        } else {
            for(int po = 1; po <= 9;po++) {
                if(isValid(grid,i,j,po)) {
                    grid[i][j] = po;
                    solve(grid,ni,nj);
                    grid[i][j] = 0;
                }
            }
        }
        
    }
    static boolean isValid(int[][] grid,int x,int y,int val) {
        for(int j=0;j < grid[0].length;j++ ){
            if(grid[x][j] == val){
                return false;
            }
        }
        for(int i=0;i < grid.length;i++ ){
            if(grid[i][y] == val){
                return false;
            }
        }
        int nx = x / 3 * 3;
        int ny = y / 3 * 3;
        for(int i = 0 ; i < 3; i++){
            for(int j=0; j < 3; j++) {
                if(grid[nx+i][ny+j] == val) {
                    return false;
                }
            }
        }
        return true;
    }
    
    static void printGrid (int grid[][])
    {
        for(int i=0; i < grid.length; i++) {
            for(int j=0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
        }
            System.out.println();
    }
}
