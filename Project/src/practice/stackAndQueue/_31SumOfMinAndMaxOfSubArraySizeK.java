package practice.stackAndQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _31SumOfMinAndMaxOfSubArraySizeK {
    // O(n*k),O(1)
    public static void main(String[] args) {
        int arr[] = {2, 5, -1, 7, -3, -1, -2} ;
        int k = 4;
        System.out.println(SumOfKsubArray(arr, k));
    }  
    private static int SumOfKsubArray(int[] a,int k) {
        Queue<Integer> q = new LinkedList<>();
        int sum = 0;
        for(int i = 0; i <= a.length-k;i++){            
            int min = 0;
            int max = 0;
            for(int j=i; j < i+k; j++){
                if(min > a[j]){
                    min = a[j];
                }
                if(max < a[j]){
                    max = a[j];
                }
            }
            System.out.println(min + ", " + max);
            sum += min + max;
        } 
        return sum;
    }
}
