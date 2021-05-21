public class _7UniquePaths62 {
    public int uniquePaths(int m, int n) {
        int[][] a = new int[m][n];
        return solve(a,m,n);
    }
    
    private static int solve(int[][] a,int r,int c) {
       if(a.length == 1 && a[0].length == 1){
           return 1;
       }
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(i == 0 && j == 0) {
                    a[i][j] = 0;
                } else if(i == 0 || j == 0) {
                    a[i][j] = 1;
                } else {
                    a[i][j] = a[i-1][j] + a[i][j-1]; 
                }
            }
        }
        return a[r-1][c-1];
    }
}
