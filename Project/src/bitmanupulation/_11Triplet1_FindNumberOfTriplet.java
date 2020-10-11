package bitmanupulation;

import java.util.Scanner;

public class _11Triplet1_FindNumberOfTriplet {
    private static void solution(int[] a) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            int val = a[i];
            for (int j = i + 1; j < a.length; j++) {
                val = val ^ a[j];
                if(val == 0) {
                    count += j - i;
                }
            }
        }
        System.out.println(count);
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n =  scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        solution(arr);
    }

}
