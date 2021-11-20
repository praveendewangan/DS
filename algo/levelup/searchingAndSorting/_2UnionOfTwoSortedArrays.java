import java.util.*;
import java.io.*;

public class _2UnionOfTwoSortedArrays {

    /*You have to complete union function and return an Arraylist which contains union elements of the two arrays*/
    public static ArrayList<Integer> union(int[] arr1,int[] arr2) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = arr1.length;
        int m = arr2.length;
        int i = 0;
        int j = 0;

        while(i < n && j < m) {
            if(arr1[i] == arr2[j]) {
                if(res.size() == 0 || res.get(res.size() - 1) != arr1[i]) {
                    res.add(arr1[i]);
                }
                i++;
                j++;
            } else if(arr1[i] < arr2[j]) {
                if(res.size() == 0 || res.get(res.size() - 1) != arr1[i]) {
                    res.add(arr1[i]);
                }
                i++;
            } else {
                if(res.size() == 0 || res.get(res.size() - 1) != arr2[j]) {
                    res.add(arr2[j]);
                }
                j++;
            }
        }

        // either i will remain or j will remain
        while(i < n) {
            if(res.size() == 0 || res.get(res.size() - 1) != arr1[i]) {
                res.add(arr1[i]);
            } 
            i++;
        }

        while(j < m) {
            if(res.size() == 0 || res.get(res.size() - 1) != arr2[j]) {
                res.add(arr2[j]);
            } 
            j++;
        }
        return res;
    }

    public static void main(String[]args) {
        Scanner scn = new Scanner(System.in);
        //input work
        int n = scn.nextInt();
        int[]a = new int[n];
        for(int i=0; i < n;i++) {
            a[i] = scn.nextInt();
        }

        int m = scn.nextInt();
        int[]b = new int[m];
        for(int i=0;i < m;i++) {
            b[i] = scn.nextInt();
        }

        ArrayList<Integer>ans = union(a,b);

        //print answer list
        for(int val : ans) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}