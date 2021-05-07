
    import java.io.*;
    import java.util.*;
    
    public class _15CountSort {
    
      public static void countSort(int[] arr, int min, int max) {
        int[] fmap = new int[max - min + 1];
        
        // 1. Fill fmap
        for(int i = 0; i < arr.length; i++) {
            int idx = arr[i] - min;
            fmap[idx]++;
        }
        // 2. Fill array
        int idx = 0;
        for(int i = 0; i < fmap.length; i++) {
            int fq = fmap[i];
            int val = i + min;
            for(int j = 0; j < fq; j++) { 
                arr[idx] = val;
                idx++;
            }
        }
       
      }
      public static void countSort1(int[] arr, int hi) {
        int[] fmap = new int[hi + 1];
        
        // 1. fill fmap
        for(int i = 0; i < arr.length; i++) {
            int val = arr[i];
            fmap[val]++;
        }

        // 2. fill in array
        int indx = 0;
        for(int i = 0; i < fmap.length; i++) {
            int fq = fmap[i];
            int val = i;

            for(int j = 0; j < fq; j++) {
                arr[indx] = val;
                indx++;
            }
        }
    }

    public static void countSort2(int[] arr, int min, int max) {
        int[] fmap = new int[max - min + 1];
        // 1. fill frequency map
        for(int i = 0; i < arr.length; i++) {
            int indx = arr[i] - min;
            fmap[indx]++;
        }
        // 2. fill array
        int indx = 0;
        for(int i = 0; i < fmap.length; i++) {
            int fq = fmap[i];
            int val = i + min;
            for(int j = 0; j < fq; j++) {
                arr[indx] = val;
                indx++;
            }
        }
    }

    private static void countSortStable(int[] a, int min,int max) {
      int[] fmap = new int[max - min + 1];
      // 1. Fill fmap
      for(int i = 0; i < a.length; i++) {
          int idx = a[i] - min;
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
            int val = a[i];
            // index in fmap
            int idx = val - min;
            // position where we have to place in new array
            int pos = fmap[idx];
            // place it
            narr[pos] = val;
            // reduce the prefix sum, i.e. position for same upcoming element
            fmap[idx]--;
        }
        for(int i = 0; i < a.length; i++) {
            a[i] = narr[i];
        }
    }
      public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
          System.out.println(arr[i]);
        }
      }
    
      public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
          arr[i] = scn.nextInt();
          max = Math.max(max, arr[i]);
          min = Math.min(min, arr[i]);
        }
        countSort(arr,min,max);
        print(arr);
      }
    
    }