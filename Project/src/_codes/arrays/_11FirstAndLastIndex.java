package _codes.arrays;

import java.util.Scanner;

public class _11FirstAndLastIndex extends Util{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        takeInput(a,scn);
        int data = scn.nextInt();
        int fidx = findIdx(a,"FIRST_IDX",data);
        int lidx = findIdx(a,"LAST_IDX",data);
        System.out.println(fidx);
        System.out.println(lidx);
    }

    private static int findIdx(int[] a,String flag,int data){
        int idx = -1;
        int i = 0;
        int j = a.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(a[m] == data) {
                idx = m;
                if(flag.equals("FIRST_IDX")){
                    j = m - 1;
                } else {
                    i = m + 1;
                }
            } else if(a[m] < data) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return idx;
    }
}
