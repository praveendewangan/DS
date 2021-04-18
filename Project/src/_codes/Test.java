package _codes;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
        int[] a = {-12, 11, -13, -5, 6, -7, 5, -3, -6};
        int i = 0;
        int j = a.length-1;
        while(i <= j) {
            if(a[i] > 0){
                swap(a,i,j);
                j--;
            } else {
                i++;
            }
        }
        for (int val : a) {
            System.out.print(val + " ");
        }
    }
    private static void swap(int[] a,int i,int j) {
        int val = a[i];
        a[i] = a[j];
        a[j] = val;
    }
}
