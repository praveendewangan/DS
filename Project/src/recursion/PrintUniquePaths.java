package recursion;

public class PrintUniquePaths {
    public static void main(String[] args) {
        System.out.println(getUniquePathCount(0,0,3));
        System.out.println(getUniquePathCountDynamic(3,4));
    }

    private static int getUniquePathCount(int n,int m,int l) {
        if(n == l-1 || m == l-1){
            return 1;
        }
        return getUniquePathCount(n,m+1,l) + getUniquePathCount(n+1,m,l);
    }
    private static int getUniquePathCountDynamic(int n,int m) {
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(i==0 || j==0){
                    a[i][j] = 1;
                } else {
                    a[i][j] = a[i-1][j] + a[i][j-1];
                }
            }
        }
        return a[n-1][m-1];

    }
}
