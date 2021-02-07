package practice.matrix;
public class _7FindASpecificPair {
    // O(n^2),O(n)
    public static void main(String[] args) {
        int N = 5; 
  
        int mat[][] = { 
                      { 1, 2, -1, -4, -20 }, 
                      { -8, -3, 4, 2, 1 }, 
                      { 3, 8, 6, 1, 3 }, 
                      { -4, -1, 1, 7, -6 }, 
                      { 0, -4, 10, -5, 1 } 
                   }; 
        System.out.println(find(N, mat));
    }
    public static int find(int n,int[][] m){
        int maxVal = Integer.MIN_VALUE;
        int[][] maxArr = new int[n][n];
        maxArr[n-1][n-1] = m[n-1][n-1];
        // update Last row
        for(int i=n-2;i>=0;i--){
            if(m[n-1][i] > maxVal) {
                maxVal = m[n-1][i];
            }
            maxArr[n-1][i] = maxVal;
        }
        
        // update Last column
        for(int i=n-2;i>=0;i--){
            if(m[i][n-1] > maxVal) {
                maxVal = m[i][n-1];
            }
            maxArr[i][n-1] = maxVal;
        }

        // Update rest of matrix
        for(int i=n-2;i>=0;i--){
            for(int j=n-2;j>=0;j--) {
                if(maxArr[i+1][j+1] - m[i][j] > maxVal) {
                    maxVal = maxArr[i+1][j+1] - m[i][j];
                }

                maxArr[i][j] = Math.max(m[i][j],Math.max(maxArr[i][j+1], maxArr[i+1][j]));
            }
        }
        return maxVal;
    }   
}
