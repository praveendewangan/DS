package _codes.arrays;

import java.util.Scanner;

public class _16ExitPointOfaMatrix1 {
    
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int r = scn.nextInt();
        int c = scn.nextInt();
        int[][] a = new int[r][c];
        takeInput(a,scn);
        int i = 0;
        int j = 0;
        boolean n = false;
        boolean s = false;
        boolean e = true;
        boolean w = false;
        while(i < r && j < c && i >= 0 && j >= 0) {
            if(a[i][j] == 0){
                if(e){
                    j++;
                } else if(s) {
                    i++;
                } else if(w) {
                    j--;
                } else {
                    i--;
                }
            } else if(a[i][j] == 1) {
                if(e){
                    i++;
                    s = true;
                    e = false;
                } else if(s) {
                    j--;
                    w = true;
                    s = false;
                } else if(w) {
                    i--;
                    w = false;
                    n = true;
                } else {
                    j++;
                    n = false;
                    e = true;
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
