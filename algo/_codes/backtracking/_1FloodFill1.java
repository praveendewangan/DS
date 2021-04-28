
import java.io.*;
import java.util.*;
public class _1FloodFill1 {

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
        floodfill(arr, 0, 0, "");
    }
    
    // asf -> answer so far
    public static void floodfill(int[][] maze, int sr, int sc, String asf) {
            if(sr == maze.length - 1 && sc == maze[0].length - 1){
                System.out.println(asf);
                return;
            }
        if(sr < 0 || sr >= maze.length || sc < 0 || sc >= maze[0].length || maze[sr][sc] == 1){
            return;
        }
        
            maze[sr][sc] = 1;
            floodfill(maze,sr-1,sc,asf + 't');
            floodfill(maze,sr,sc-1,asf + 'l');
            floodfill(maze,sr+1,sc,asf + 'd');
            floodfill(maze,sr,sc+1,asf + 'r');
            maze[sr][sc] = 0;
        
        
    }
}

