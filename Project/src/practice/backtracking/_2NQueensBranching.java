package practice.backtracking;

public class _2NQueensBranching {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] arr = new boolean[n][n];
        boolean[] col = new boolean[n];
        boolean[] ndig = new boolean[2 * n - 1]; // row + col
        boolean[] rdig = new boolean[2 * n - 1]; // row - col + arr.length - 1

        print(arr,0,col,ndig,rdig,"");
    }
    private static void print(boolean[][] arr,int row,boolean[] cols,boolean[] ndig,
            boolean[] rdig,String ans) {
        if (row == arr.length) {
            System.out.println(ans+".");
            return;
        }
        for (int col = 0; col < arr[0].length; col++) {
            if(cols[col] == false && ndig[row + col] == false && rdig[row - col + arr.length - 1] == false) {
                arr[row][col] = true;
                cols[col] = true;
                ndig[row + col] = true;
                rdig[row - col + arr.length - 1] = true;
                print(arr,row + 1,cols,ndig,rdig,ans + row + "-" + col + ",");
                arr[row][col] = false;
                cols[col] = false;
                ndig[row + col] = false;
                rdig[row - col + arr.length - 1] = false;
            }
        }
    }
}
