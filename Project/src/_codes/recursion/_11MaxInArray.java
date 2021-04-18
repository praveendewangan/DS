package _codes.recursion;

import java.util.Scanner;

public class _11MaxInArray {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        takeInput(a,scn);
        System.out.println(maxOfArray(a,0));
    }

    public static int maxOfArray(int[] arr, int idx){
        if(idx == arr.length) return -1;
        int n = maxOfArray(arr,idx+1);
        return arr[idx] > n ? arr[idx] : n;
    }

    private static void takeInput(int[] a,Scanner scn) {
        for(int i = 0; i < a.length; i++) {
            a[i] = scn.nextInt();
        }
    }
}
