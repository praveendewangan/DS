package dynamicprograms;

import java.util.Scanner;

public class _25BuySellWithMultipleTransaction {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }
        int bd = 0;
        int sd = 0;
        int profit = 0;

        for (int i = 1; i < a.length; i++) {
            if(a[i] >= a[i-1]) {
                sd++;
            } else {
                profit += a[sd] - a[bd];
                bd = sd = i;
            }
        }
        profit += a[sd] - a[bd];
        System.out.println(profit);
    }
}
