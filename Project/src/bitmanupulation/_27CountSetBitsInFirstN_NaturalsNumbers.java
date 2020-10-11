package bitmanupulation;

import java.util.Scanner;

public class _27CountSetBitsInFirstN_NaturalsNumbers {
    private static int solution(int n) {
        if(n == 0) {
            return 0;
        }
         int x = maxPower(n);
         int btilln = x * (1 << (x - 1));
         int msbBtilln = n - (1 << x) + 1;
         int restB = n - (1 << x);
         return btilln + msbBtilln + solution(restB);
    }
    private static int maxPower(int n) {
        int x = 0;
        while ((1 << x) <= n) {
            x++;
        }
        return x - 1;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(solution(n));
    }
}
