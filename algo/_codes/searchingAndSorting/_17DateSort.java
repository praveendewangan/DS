import java.io.*;
import java.util.*;

public class _17DateSort {
        
      public static void sortDates(String[] arr) {
        for(int i = 1 ; i >= 0; i--) {
            countSort(arr,i,0,0);
        }
        for(int i = 3 ; i >= 2; i--) {
            countSort(arr,i,0,0);
        }
        
        for(int i = 7 ; i >= 4; i--) {
            countSort(arr,i,0,0);
        }
        
      }
    
      public static void countSort(String[] arr,int div, int mod, int range) {
        int[] fmap = new int[10];
        for(int i = 0; i < arr.length; i++){
            int idx = arr[i].charAt(div) - '0';
            fmap[idx]++;
        }
        fmap[0]--;
        for(int i = 1;i < fmap.length;i++) {
            fmap[i] += fmap[i-1];
        }
        String[] narr = new String[arr.length];
        for(int i = arr.length-1; i >= 0; i--) {
            
            int val = arr[i].charAt(div) - '0';
            int idx = val;
            int pos = fmap[idx];
            narr[pos] = arr[i];
            fmap[idx]--;
            
        }
        
        for(int i = 0; i < arr.length; i++) {
            arr[i] = narr[i];
        }
      }
    
      public static void print(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
          System.out.println(arr[i]);
        }
      }
    
      public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
          String str = scn.next();
          arr[i] = str;
        }
        sortDates(arr);
        print(arr);
      }
    
    }
