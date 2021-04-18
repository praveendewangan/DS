package _codes.recursion;

import java.util.Scanner;

public class _12FirstIndex {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        takeInput(a,scn);
        int x = scn.nextInt();
        System.out.println(firstIndex(a,0,x));
    }

    public static int firstIndex(int[] arr, int idx, int x){
        if(idx == arr.length) return -1;
        if(arr[idx] == x){
            return idx;
        }
        
        return firstIndex(arr,idx+1,x);
    }
    
    private static void takeInput(int[] a,Scanner scn) {
        for(int i = 0; i < a.length; i++) {
            a[i] = scn.nextInt();
        }
    }
}
