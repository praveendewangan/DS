package recursion;

import java.util.Scanner;
// Depth first search
public class FloodFill {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println("");
        }
        boolean[][] visited = new boolean[n][m];
        print(arr,0,0,"",visited);
    }
    // TOP LEFT DOWN RIGHT
    private static void print(int[][] maze,int row,int col,String psf,boolean[][] visited) {
        if(row < 0 || col < 0 || row == maze.length || col == maze[0].length
                || maze[row][col] == 1 || visited[row][col] == true) {
            return;
        }
        if(row == maze.length-1 && col == maze[0].length-1){
            System.out.println(psf);
            return;
        }
        visited[row][col] = true;
        print(maze,row-1,col,psf+"t",visited);
        print(maze,row,col-1,psf+"l",visited);
        print(maze,row+1,col,psf+"d",visited);
        print(maze,row,col+1,psf+"r",visited);
        visited[row][col] = false;
    }
}
