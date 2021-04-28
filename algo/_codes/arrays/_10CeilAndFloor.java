package _codes.arrays;

import java.util.Scanner;

public class _10CeilAndFloor extends Util {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        takeInput(a,scn);
        int data = scn.nextInt();

        int ceil = -1;
        int floor = -1;

        int i = 0;
        int j = n-1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(a[m] == data) {
                ceil = floor = data;
                break;
            } else if(a[m] < data) {
                i = m + 1;
                floor = a[m];
            } else {
                j = m - 1;
                ceil = a[m];
            }
        }
        System.out.println(ceil);
        System.out.println(floor);
    }
}
