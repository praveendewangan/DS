package sortingalgo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _12Sort01 {

    public static void sort01(int[] arr){
        int i = 0;
        int j = 0;
        while (i < arr.length) {
            if(arr[i] == 0) {
                swap(arr,i,j);
                i++;
                j++;
            } else {
                i++;
            }
        }
    }

    // used for swapping ith and jth elements of array
    public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping index " + i + " and index " + j);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(int[] arr){
        for(int i = 0 ; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[] arr = new int[n];
        for(int i = 0 ;i < n; i++){
            arr[i] = Integer.parseInt(br.readLine().trim());
        }
        sort01(arr);
        print(arr);
    }

}
