package array;

import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[] arr = new int[scn.nextInt()];
        for (int i=0;i<arr.length;i++) {
            arr[i] = scn.nextInt();
        }
        for (int i=0;i<arr.length/2;i++) {
            int temp = arr[arr.length-1-i];
            arr[arr.length-1-i] = arr[i];
            arr[i] = temp;
        }
        for (int i=0;i<arr.length;i++) {
            System.out.println(arr[i]);
        }
    }

}
