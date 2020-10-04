package bitmanupulation;

import java.util.Scanner;

public class _3KernighanAlgorithm {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int counter = 0;
        while (n != 0) {
            int rmsb = n & -n;
            n = n - rmsb;
            counter++;
        }
        System.out.println(counter);
    }
}
