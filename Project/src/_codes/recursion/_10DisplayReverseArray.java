package _codes.recursion;

import java.util.Scanner;

public class _10DisplayReverseArray {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        takeInput(a,scn);
        displayArr(a,0);
    }

    public static void displayArr(int[] arr, int idx){
        if(idx == arr.length){
            return;
        }
        displayArr(arr,idx+1);
        System.out.println(arr[idx]);
    }
    
    private static void takeInput(int[] a,Scanner scn) {
        for(int i = 0; i < a.length; i++) {
            a[i] = scn.nextInt();
        }
    }
}
