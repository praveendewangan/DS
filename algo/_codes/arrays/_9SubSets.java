package _codes.arrays;

import java.util.Scanner;

public class _9SubSets extends Util{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        takeInput(a,scn);
        int ts = (int) Math.pow(2, n);
        int div = (int) Math.pow(10, n-1);
        for(int i = 0; i < ts; i++) {
            int bin = decToBin(i);
            for(int j = 0; j < n; j++){
                int r = bin % div;
                int q = bin / div;
                
                if(q == 0){
                    System.out.print("-\t");
                } else {
                    System.out.print(a[j] + "\t");
                }

                div /= 10;
                bin = r;
            }
            System.out.println();
        }
    }

    private static int decToBin(int n) {
        int ans = 0;
        int p = 1;
        while(n != 0) {
            int r = n % 2;
            n /= 2;
            ans += r * p;
            p *= 10;
        }
        return ans;
    }
}
