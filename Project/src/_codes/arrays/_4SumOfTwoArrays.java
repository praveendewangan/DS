package _codes.arrays;

import java.util.Scanner;

public class _4SumOfTwoArrays {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int[] a1 = new int[n1];
        takeInput(a1,scn);

        int n2 = scn.nextInt();
        int[] a2 = new int[n2];
        takeInput(a1,scn);
        int len = n1 > n2 ? n1 + 1: n2 + 1;
        int i = n1 - 1;
        int j = n2 - 1;
        int c = 0;
        int[] ans = new int[len];
        for(int k = len - 1; k >= 0; k--){
            int val1 = i >= 0 ? a1[i] : 0;
            int val2 = j >= 0 ? a2[j] : 0;

            int sum = val1 + val2 + c;
            c = sum / 10;
            sum = sum % 10;
            ans[k] = sum;
            j--;
            i--;
        }
        if(ans[0] != 0) {
            System.out.println(ans[0]);
        }
        for(int k = 1; k < len; k++) {
            System.out.println(ans[k]);
        }
    }
    private static void takeInput(int[] a,Scanner scn) {
        for(int i = 0; i < a.length; i++) {
            a[i] = scn.nextInt();
        }
    }
 }
}
