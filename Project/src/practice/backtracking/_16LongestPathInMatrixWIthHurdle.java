package practice.backtracking;

public class _16LongestPathInMatrixWIthHurdle {
    static int max = Integer.MIN_VALUE; 
    public static void main(String[] args) {
        int a[][] = 
            { 
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
                { 1, 1, 0, 1, 1, 0, 1, 1, 0, 1 }, 
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } 
            };
            boolean[][] visited = new boolean[a.length][a[0].length];
            maxPath(a, 0, 0, 1,7,visited);
            System.out.println(max);
    }

    public static void maxPath(int[][] a,int i,int j,int sum,int dest,boolean[][] visited) {
        if(i < 0 || j < 0 || i == a.length || j == a[0].length || a[i][j] == 0 || visited[i][j]) {
            return;
        } 
        if(i == a.length-1 && j == dest) {
            if(max < sum){
                max = sum;
            }
            return;
        }
        visited[i][j] = true;
        maxPath(a, i+1, j, sum+1,dest,visited);
        maxPath(a, i, j+1, sum+1,dest,visited);
        maxPath(a, i-1, j, sum+1,dest,visited);
        maxPath(a, i, j-1, sum+1,dest,visited);
        visited[i][j] = false;
    }
}
