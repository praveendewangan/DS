package _codes.arrays;

import java.util.Scanner;

public class _3BarChart {
   public static void main(String[] args) {
       Scanner scn = new Scanner(System.in);
    //    int n = scn.nextInt();
    //    int[] a = new int[n];
            int[] a = {3,1,0,7,5};
    //    takeInput(a,scn);

       int ht = findMax(a);

       for(int floor = ht; floor > 0; floor--) {
           for(int i = 0 ; i < a.length; i++){
                if(a[i] >= floor){
                    System.out.print("*\t");
                } else {
                    System.out.print("\t");
                }
           }
           System.out.println();
       }

   } 
   private static int findMax(int[] a) {
       int ans = Integer.MIN_VALUE;
       for(int i = 0; i < a.length; i++) {
            if(a[i] > ans) {
                ans = a[i];
            }
       }
       return ans;
   }
   private static void takeInput(int[] a,Scanner scn) {
       for(int i = 0; i < a.length; i++) {
           a[i] = scn.nextInt();
       }
   }
}
