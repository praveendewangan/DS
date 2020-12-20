package sortingalgo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _4MergeTwoSortedArrays {

    public static int[] mergeTwoSortedArrays(int[] a, int[] b){
        int[] res = new int[a.length + b.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < a.length && j < b.length) {
            if(a[i] < b[j]) {
                res[k] = a[i];
                k++;
                i++;
            } else {
                res[k] = b[j];
                k++;
                j++;
            }
        }
        while (i < a.length) {
            res[k] = a[i];
            k++;
            i++;
        }
        while (j < b.length) {
            res[k] = b[j];
            k++;
            j++;
        }
        return res;
    }

    public static void print(int[] arr){
        for(int i = 0 ; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine().trim());
        }
        int m = Integer.parseInt(br.readLine().trim());
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(br.readLine().trim());
        }
        int[] mergedArray = mergeTwoSortedArrays(a,b);
        print(mergedArray);
    }

}
