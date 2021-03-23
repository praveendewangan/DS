package practice.backtracking;

public class _11ShortestPath {
    static int path = Integer.MAX_VALUE;
    public static void main(String[] args) {     
    // Input matrix with landmines shown with number 0
    int[][] mat = { 
        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
        { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
        { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 }, 
        { 1, 1, 1, 1, 0, 1, 1, 1, 1, 1 }, 
        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
        { 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 }, 
        { 1, 0, 1, 1, 1, 1, 1, 1, 0, 1 }, 
        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
        { 0, 1, 1, 1, 1, 0, 1, 1, 1, 1 }, 
        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
        { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 } };
    boolean[][] visited = new boolean[mat.length][mat[0].length];
    int[][] mat1 = { 
        { 1, 1, 1}, 
        { 1, 0, 1},
        { 1, 1, 1}};
        findShortestPath(mat,0,0,0,visited);
        System.out.println(path);
    }

    private static void findShortestPath(int[][] a,int i,int j,int pi,boolean[][] visited) {
        if(i < 0 || j < 0 || i >= a.length || j >= a[0].length || a[i][j] == 0 || visited[i][j]){
            return;
        } 
        if(j == a[0].length-1){
            if(path > pi) {
                path = pi;
                return;
            }
        }
        visited[i][j] = true;
        findShortestPath(a,i+1,j,pi+1,visited);
        findShortestPath(a,i,j+1,pi+1,visited);
        findShortestPath(a,i,j-1,pi+1,visited);
        findShortestPath(a,i-1,j,pi+1,visited);
        visited[i][j] = false;
    }
}
