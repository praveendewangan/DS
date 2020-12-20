package _2dArray;

import java.util.Scanner;

public class _9SearchInSortedMatrix {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] a = new int[n][m];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                a[i][j] = scn.nextInt();
            }
        }
        print(a);
        int i = 0;
        int j = a[0].length - 1;
        while (i < a.length && j >= 0) {
            if(a[i][j] == num) {
                System.out.println(i+"\t"+j);
                return;
            } else if(a[i][j] > num){
                j--;
            } else {
                i++;
            }
        }
        System.out.println("NO data matched::::");
    }
    private static void print(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j]+"\t");
            }
            System.out.println("");
        }
    }
}
