import java.io.*;
import java.util.*;

public class _4MergeTwoSortedArrays {

      public static int[] mergeTwoSortedArrays(int[] a, int[] b){
        int[] res = new int[a.length+b.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < a.length && j < b.length) {
            if(a[i] < b[j]){
                res[k++] = a[i++];
            } else if(a[i] > b[j]){
                res[k++] = b[j++];
            } else {
                res[k++] = a[i++];
                res[k++] = b[j++];
            }
        }
        while(i < a.length) {
            res[k++] = a[i++];
        }
        while(j < b.length) {
            res[k++] = b[j++];
        }
        
        return res;
      }
    
      public static int[] mergeTwoSortedArrays2(int[] arr1, int[] arr2) {
        int s1 = arr1.length;
        int s2 = arr2.length;

        int[] res = new int[s1 + s2];

        int i = 0; // itr for arr1
        int j = 0; // itr for arr2
        int k = 0; // help to fill the res

        while(i < s1 || j < s2) {
            int ival = i < s1 ? arr1[i] : Integer.MAX_VALUE;
            int jval = j < s2 ? arr2[j] : Integer.MAX_VALUE;

            if(ival > jval) {
                res[k] = jval;
                j++;
            } else {
                res[k] = ival;
                i++;
            }
            k++;
        }

        return res;
    }

      public static void print(int[] arr){
        for(int i = 0 ; i < arr.length; i++){
          System.out.println(arr[i]);
        }
      }
      public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for(int i = 0 ; i < n; i++){
          a[i] = scn.nextInt();
        }
        int m = scn.nextInt();
        int[] b = new int[m];
        for(int i = 0 ; i < m; i++){
          b[i] = scn.nextInt();
        }
        int[] mergedArray = mergeTwoSortedArrays(a,b);
        print(mergedArray);
      }
    
    }
