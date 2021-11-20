import java.util.*;
import java.io.*;

public class _3SearchA2DMatrixLC74 {

    /*your task is to complete this function which returns true if target exists in the matrix
    else return false*/
    public static boolean search(int[][]matrix,int target) {
        int r = binarySerachForPotentialROw(matrix,target);
        if(r == -1) {
            return false;
        }
        return binarySearch(matrix,r,target);
    }
    
    private static int binarySerachForPotentialROw(int[][]matrix,int target) {
        int lo = 0;
        int hi = matrix.length-1;
        int li = matrix[0].length-1;
        
        while(lo <= hi) {
            int m = (lo+hi) / 2;
            
            if(matrix[m][0] <= target && target <= matrix[m][li]) {
                return m;
            } else if(matrix[m][0] < target) {
                lo = m + 1;
            } else {
                hi = m - 1; 
            }
        }
        return -1;
    }
    private static boolean binarySearch(int[][]matrix,int r,int target) {
        int lo = 0;
        int hi = matrix[0].length-1;
        
        while(lo <= hi) {
            int m = (lo+hi) / 2;
            
            if(matrix[r][m] == target) {
                return true;
            } else if(matrix[r][m] < target) {
                lo = m + 1;
            } else {
                hi = m - 1; 
            }
        }
        return false;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();

        int[][]matrix = new int[m][n];

        for(int i=0; i < m;i++) {
            for(int j=0; j < n;j++) {
                matrix[i][j] = scn.nextInt();
            }
        }

        int target = scn.nextInt();

        boolean isFound = search(matrix,target);
        System.out.println(isFound);

    }
}