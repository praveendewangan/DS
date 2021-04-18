package _codes.recursion;

import java.util.Scanner;

public class _7PrintZigZag {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        pzz(n);
        // pzz(n);
    }

    
    public static void pzz(int n){
        if(n == 0) {
            return;
            
        }
        System.out.print(n + " ");
        pzz(n-1);
        System.out.print(n + " ");
        pzz(n-1);
        System.out.print(n + " ");
    }

}
