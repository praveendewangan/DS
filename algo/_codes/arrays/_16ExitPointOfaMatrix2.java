package _codes.arrays;

import java.util.Scanner;

public class _16ExitPointOfaMatrix2 {
    
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int r = scn.nextInt();
        int c = scn.nextInt();
        int[][] a = new int[r][c];
        takeInput(a,scn);
        int i = 0;
        int j = 0;
        int num = 0;
        while(i < r && j < c && i >= 0 && j >= 0) {
            if(a[i][j] == 0){
                if(num == 0){
                    j++;
                } else if(num == 1) {
                    i++;
                } else if(num == 2) {
                    j--;
                } else {
                    i--;
                }
            } else if(a[i][j] == 1) {
                if(num == 0){
                    i++;
                    num = 1;
                } else if(num == 1) {
                    j--;
                    num = 2;
                } else if(num == 2) {
                    i--;
                    num = 3;
                } else {
                    j++;
                    num = 0;
                }
            }
            
        }
        if( i < 0) {
            i = 0;
        } else if (i >= a.length) {
            i = a.length-1;
        }
        
        if( j < 0) {
            j = 0;
        } else if (j >= a[0].length) {
            j = a[0].length-1;
        }
        System.out.println(i);
        System.out.println(j);
        
        
    }
    private static void takeInput(int[][] a,Scanner scn) {
         for(int i = 0; i < a.length; i++) {
             for(int j = 0; j < a[0].length; j++) {
                 a[i][j] = scn.nextInt();
             }
         }
    }

}
