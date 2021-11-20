import java.util.*;
import java.io.*;

public class _5FindPivotIndexLC724 {

    public static int pivot_index(int[]arr) {
       int sum = 0;
       for(int val : arr) {
           sum += val;
       }
       int left = 0;
       int right = sum;
       for(int i=0; i < arr.length; i++) {
           right -= arr[i];
           if(left == right){
               return i;
           }
           left += arr[i];
       }
        return -1;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]arr = new int[n];

        for(int i=0; i < arr.length;i++) {
            arr[i] = scn.nextInt();
        }

        int pi = pivot_index(arr);
        System.out.println(pi);
    }
}