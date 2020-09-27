package backtrackingwithrecursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GoldMine2 {
    private static  int max = 0;
    private static void countTotalGolds(int[][] a,int i,int j,boolean[][] visited,List<Integer> bag) {
        if(i < 0 || j < 0 || i >= a.length || j >= a[0].length || a[i][j] == 0 || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        bag.add(a[i][j]);
        countTotalGolds(a,i-1,j,visited,bag);
        countTotalGolds(a,i,j-1,visited,bag);
        countTotalGolds(a,i+1,j,visited,bag);
        countTotalGolds(a,i,j+1,visited,bag);
    }
    private static void callGoldmine(int[][] a) {
        boolean[][] visited = new boolean[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if(a[i][j] != 0 && visited[i][j] == false) {
                    List<Integer> bag = new ArrayList<>();
                    countTotalGolds(a,i,j,visited,bag);
                    int sum = 0;
                    for (int val : bag) {
                        sum += val;
                    }
                    if(sum > max) {
                        max = sum;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] a = new int[n][m];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                a[i][j] = scn.nextInt();
            }
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println(" ");
        }
        callGoldmine(a);
        System.out.println(max);
    }
}
