package recursion;

public class _28PrintNQueens {
    public static void main(String[] args) {
        int[][] arr = new int[4][4];
        printQueen(arr,"",0);
    }
    private static void printQueen(int[][] arr,String psf,int row) {
        if(row == arr.length){
            System.out.println(psf + ".");
            return;
        }
        for (int col = 0; col < arr.length; col++) {
            if(isQueenSafe(arr,row,col)==true) {
                arr[row][col] = 1;
                printQueen(arr,psf+row+"-"+col+",",row+1);
                arr[row][col] = 0;
            }
        }
    }
    private static boolean isQueenSafe(int[][] arr,int row,int col) {
        for (int i = row-1,j=col; i >= 0; i--) {
            if(arr[i][j] == 1){
                return false;
            }
        }
        for (int i = row-1,j=col-1; i >= 0 && j >=0; i--,j--) {
            if(arr[i][j] == 1){
                return false;
            }
        }
        for (int i = row-1,j=col+1; i >= 0 && j < arr.length; i--,j++) {
            if(arr[i][j] == 1){
                return false;
            }
        }
        return true;
    }
}
