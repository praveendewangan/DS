package recursion;

import java.util.Scanner;

public class FloodFillImageColor {
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
        print(arr,0,0,1,3);
        System.out.println("#########################");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println("");
        }
    }
    // TOP LEFT DOWN RIGHT
    private static void print(int[][] maze,int row,int col,int src,int clr) {
        if(row < 0 || col < 0 || row == maze.length || col == maze[0].length || maze[row][col] != src) {
            return;
        }
        if(maze[row][col] == src){
            maze[row][col] = clr;
        }
        print(maze,row-1,col,src,clr);
        print(maze,row,col-1,src,clr);
        print(maze,row+1,col,src,clr);
        print(maze,row,col+1,src,clr);
    }
}
