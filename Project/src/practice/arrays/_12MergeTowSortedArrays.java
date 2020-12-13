package practice.arrays;


import java.util.Arrays;

/*Given two sorted arrays arr1[] of size N and arr2[] of size M. Each array is sorted in non-decreasing order. Merge the two arrays into one sorted array in non-decreasing order without using any extra space.


        Example 1:

        Input:
        N = 4, M = 5
        arr1[] = {1, 3, 5, 7}
        arr2[] = {0, 2, 6, 8, 9}
        Output: 0 1 2 3 5 6 7 8 9
        Explanation: Since you can't use any
        extra space, modify the given arrays
        to form
        arr1[] = {0, 1, 2, 3}
        arr2[] = {5, 6, 7, 8, 9}*/
public class _12MergeTowSortedArrays {
    public static void main(String[] args) {
        int arr1[] = {1, 3, 5, 7};
        int arr2[] = {0, 2, 6, 8, 9};
        int n = 4;
        int m = 5;
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
