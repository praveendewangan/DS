package _codes.arrays;

import java.util.Scanner;

public class Util {
    public static void takeInput(int[] a, Scanner scn) {
        for(int i = 0; i < a.length; i++) {
            a[i] = scn.nextInt();
        }
    }   
}
