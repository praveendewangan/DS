package practice.matrix;

public class _2SearchElementInMatrix {
    // O(n*m) , O(1)
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length-1;
        while(i < matrix.length && j >= 0){
            if(matrix[i][j] > target){
                j--;
            } else if(matrix[i][j] < target){
                i++;
            } else {
                return true;
            }
        }
        return false;
    }  
    
    // Log(n*m) , O(1);
    public boolean searchMatrix1(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int lo = 0;
        int hi = (n*m) - 1;
        while(lo <= hi){
            int mid = (lo + (hi - lo)/2);
            if(matrix[mid/n][mid%m] == target) {
                return true;
            } else if(matrix[mid/n][mid%m] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return false;
    }  
}
