package bitmanupulation;

import java.util.Scanner;

public class _10FindDuplicateAndMissingNum {
    private static void solution(int[] arr) {
        int xor = 0;
        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];
        }
        for (int i = 1; i <= arr.length; i++) {
            xor ^= i;
        }
        int rmsb = xor & -xor;
        int x = 0;
        int y = 0;
        for (int n : arr) {
            if ((n & rmsb) == 0) {
                x = x ^ n;
            } else {
                y = y ^ n;
            }
        }
        for (int i = 1; i <= arr.length; i++) {
            if ((i & rmsb) == 0) {
                x = x ^ i;
            } else {
                y = y ^ i;
            }
        }
        for (int n : arr) {
            if (n == x) {
                System.out.println("Missing Number -> "+y);
                System.out.println("Repeating Number -> "+x);
                break;
            } else if(n == y){
                System.out.println("Missing Number -> "+x);
                System.out.println("Repeating Number -> "+y);
                break;
            }
        }
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
