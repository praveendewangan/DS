import java.io.*;
import java.util.*;

public class _16RadixSOrt {
        
      public static void radixSort(int[] arr) {
        int max = Integer.MIN_VALUE;
        for(int a : arr){
            if(a > max) {
                max = a;
            }
        }
        
        int exp = 1;
        while(exp < max) {
            countSort(arr,exp);
            exp *= 10;
        }
      }
    
      public static void countSort(int[] a, int exp) {
        int[] fmap = new int[10];
          // 1. Fill fmap
          for(int i = 0; i < a.length; i++) {
              int idx = (a[i] / exp) % 10;
              fmap[idx]++;
          }
    
          // 2. Generate prefix sum arr
          fmap[0]--;
          for(int i = 1; i < fmap.length; i++) {
            fmap[i] += fmap[i - 1];
          }
    
          // make a new array and fill it in reverse direction
            // also decrease psum[i], while place ith element
            int[] narr = new int[a.length];
    
            for(int i = a.length - 1; i>= 0; i--) {
              
                // val to place
                int val = (a[i] / exp) % 10;
                // index in fmap
                int idx = val;
                // position where we have to place in new array
                int pos = fmap[idx];
                // place it
                narr[pos] = a[i];
                // reduce the prefix sum, i.e. position for same upcoming element
                fmap[idx]--;
            }
            for(int i = 0; i < a.length; i++) {
                a[i] = narr[i];
            }
        System.out.print("After sorting on " + exp + " place -> ");
        print(a);
      }
    
      public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
          System.out.print(arr[i] + " ");
        }
        System.out.println();
      }
    
      public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
          arr[i] = scn.nextInt();
        }
        radixSort(arr);
        print(arr);
      }
    
    }
