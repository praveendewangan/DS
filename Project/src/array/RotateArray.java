package array;

import java.util.Scanner;

public class RotateArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[] arr = new int[scn.nextInt()];
        int length = arr.length;
        for (int i=0;i<arr.length;i++) {
            arr[i] = scn.nextInt();
        }
        int num = scn.nextInt();
        int dir = scn.nextInt();
        if(num != 0 && num != length) {
            int r = num % length;
            if (r < 0) {
                r = r + length;
            }
            if(dir == 0) {
                reverse(arr, 0, length - r - 1);
                reverse(arr, length - r, length - 1);
                reverse(arr, 0, length - 1);
            } else {
                reverse(arr, 0,  r - 1);
                reverse(arr, r, length - 1);
                reverse(arr, 0, length - 1);
            }
        }
        print(arr);

    }
    private static void print(int[] a){
        for (int n: a) {
            System.out.println(n);
        }
    }
    private static void reverse(int[] a,int start,int end){

        while ( start < end) {
            int temp = a[end];
            a[end] = a[start];
            a[start] = temp;
            start++;
            end--;
        }
    }
}
