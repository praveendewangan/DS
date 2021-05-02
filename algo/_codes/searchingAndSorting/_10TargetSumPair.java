import java.io.*;
import java.util.*;

public class _10TargetSumPair {
    
      public static void targetSumPair(int[] arr, int target){
        quickSort(arr,0,arr.length-1);
        int i = 0;
        int j = arr.length - 1;
        while(i < j) {
            int sum = arr[i] + arr[j];
            if(sum == target) {
                System.out.println(arr[i] + ", "+arr[j]);
                i++;
                j--;
            } else if(sum > target) {
                j--;
            } else {
                i++;
            }
        }
    
      }
      
        public static void quickSort(int[] arr, int lo, int hi) {
            if(lo > hi) return;
            int pivot = arr[hi];
            int pi = partition(arr,pivot,lo,hi);
            quickSort(arr,lo,pi - 1);
            quickSort(arr,pi + 1,hi);
        }
    
        public static int partition(int[] arr, int pivot, int lo, int hi) {
            int i = lo, j = lo;
            while (i <= hi) {
                if (arr[i] <= pivot) {
                swap(arr, i, j);
                i++;
                j++;
                } else {
                i++;
                }
            }
            return (j - 1);
        }
         public static void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
      public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ;i < n; i++){
          arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        targetSumPair(arr,target);
      }
    
    }