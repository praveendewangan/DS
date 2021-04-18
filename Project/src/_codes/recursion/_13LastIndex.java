package _codes.recursion;

import java.util.Scanner;

public class _13LastIndex {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        takeInput(a,scn);
        int x = scn.nextInt();
        System.out.println(lastIndex(a,n-1,x));
    }

    public static int lastIndex(int[] arr, int idx, int x){
        if(idx <= 0) return -1;
        int i = lastIndex(arr,idx-1,x);

        if(i == -1 && arr[idx] == x){
            return idx;
        }
        return i;
    }

    private static void takeInput(int[] a,Scanner scn) {
        for(int i = 0; i < a.length; i++) {
            a[i] = scn.nextInt();
        }
    }
}
