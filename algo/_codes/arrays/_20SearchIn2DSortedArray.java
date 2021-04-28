package _codes.arrays;

import java.util.Scanner;

public class _20SearchIn2DSortedArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] a = new int[n][n];
        takeInput(a,scn);
        int t = scn.nextInt();
        find(a,t);
    }
    
    private static void find(int[][] a,int t) {
        int n = a.length;
        int i = n - 1;
        int j = 0;
        while(i >= 0 && j < n) {
            if(a[i][j] == t){
                System.out.println(i);
                System.out.println(j);
                return;
            } else if(a[i][j] < t) {
                j++;
            } else {
                i--;
            }
        }
        
        
        System.out.println("Not Found");
    } 
}
