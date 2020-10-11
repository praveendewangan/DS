package bitmanupulation;

import java.util.Scanner;

public class _17Sudoku {
    private static void solution(int[][] arr,int[] rows,int[] cols,int[][] grid,int i,int j) {
        if(i == arr.length) {
            // Print array
            return;
        }
        if(arr[i][j] > 0) {
            solution(arr,rows,cols,grid, j == arr[0].length - 1 ? i + 1 : i, j == arr[0].length - 1 ? 0 : j + 1);
        } else {
            for (int k = 1; k < 9; k++) {
                if(
                    (rows[i] & (1 << k)) == 0 &&
                    (cols[j] & (1 << k)) == 0 &&
                    (grid[i/3][j/3] & (1 << k)) == 0
                ) {
                    arr[i][j] = k;
                    rows[i] ^= (1 << k);
                    cols[j] ^= (1 << k);
                    grid[i][j] ^= (1 << k);
                    solution(arr,rows,cols,grid, j == arr[0].length - 1 ? i + 1 : i, j == arr[0].length - 1 ? 0 : j + 1);
                    arr[i][j] = 0;
                    rows[i] ^= (1 << k);
                    cols[j] ^= (1 << k);
                    grid[i][j] ^= (1 << k);
                }
            }
        }

    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[][] arr = new int[9][9];
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[][] grid = new int[3][3];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int digit = scn.nextInt();
                arr[i][j] = digit;
                rows[i] |= (1 << digit);
                cols[j] |= (1 << digit);
                grid[i/3][j/3] |= (1 << digit);
            }
        }
        solution(arr,rows,cols,grid,0,0);
    }
}
