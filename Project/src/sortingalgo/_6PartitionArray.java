package sortingalgo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _6PartitionArray {

    public static void partition(int[] arr, int pivot){
        // 0 to j - 1 -> <= pivot
        // j to i - 1 -> > pivot
        // i to end -> unknown
        int i = 0;
        int j = 0;
        while (i < arr.length) {
            if(arr[i] > pivot) {
                i++;
            } else {
                swap(arr,i,j);
                i++;
                j++;
            }
        }
    }

    // used for swapping ith and jth elements of array
    public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping " + arr[i] + " and " + arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine().trim());
        }
        int pivot = Integer.parseInt(br.readLine().trim());
        partition(arr,pivot);
        print(arr);
    }

}
