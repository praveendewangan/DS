package practice.backtracking;

public class _17PrintAllPossiblePathsFronLefttoRight {
    public static void main(String[] args) {
        
        int m = 2;
        int n = 3;
        int mat[][] = { { 1, 2, 3 }, 
                        { 4, 5, 6 }};
        printPaths(mat,0,0, m, n,"");
    } 

    public static void printPaths(int[][] a,int i,int j,int m,int n,String path) {
        
        if(i >= m || j >= n) {
            
            return;
        }
        if(i == m-1 && j == n-1) {
            System.out.println(path+" "+a[i][j]);
            return;
        }
        
        
            printPaths(a, i+1, j,m,n, path+" "+a[i][j]);
            printPaths(a, i, j+1,m,n, path+" "+a[i][j]);
        
    }
}
