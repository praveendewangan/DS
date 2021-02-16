package practice.searchingAndSorting;

import java.util.Arrays;

public class _14MergeTwoSortedArraysWithoutExtraSpace {
    // O(n+m)*log(n*m),O(1)
    public void merge(int arr1[], int arr2[], int n, int m) {
        // int a[] = new int[n+m];
        int i = n-1;
        int j = 0;
        // int k = 0;
        // int length = n+m;
        while(i >= 0 && j < m) {
            if(arr1[i] > arr2[j]) {
                int temp = arr2[j];
                arr2[j] = arr1[i];
                arr1[i] = temp;
                i--;
                j++;
            } else {
                break;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
}
