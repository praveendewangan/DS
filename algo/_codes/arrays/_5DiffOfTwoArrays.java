package _codes.arrays;

import java.util.Scanner;

public class _5DiffOfTwoArrays {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int[] a1 = new int[n1];
        takeInput(a1,scn);
    
        int n2 = scn.nextInt();
        int[] a2 = new int[n2];
        takeInput(a2,scn);
    
        int len = n1 > n2 ? n1 : n2;
        int[] ans = new int[len];
        int i = n1 - 1;
        int j = n2 - 1;
        int c = 0;
        for(int k = len-1; k >= 0; k--) {
            int val1 = i >= 0 ? a1[i] : 0;
            int val2 = j >= 0 ? a2[j] : 0;
            
            int dif = val2 - val1 - c;
            if(dif < 0) {
                dif += 10;
                c = 1;
            } else {
                c = 0;
            }
            
            ans[k] = dif;
            i--;
            j--;
            
        }
        boolean flag = false;
        
        for(i = 0; i < len; i++){
            if(ans[i] != 0) {
                flag = true;
            }
            
            if(flag) {
                System.out.println(ans[i]);
            }
        }
    
    }
    private static void takeInput(int[] a,Scanner scn) {
        for(int i = 0; i < a.length; i++) {
            a[i] = scn.nextInt();
        }
    }
}
