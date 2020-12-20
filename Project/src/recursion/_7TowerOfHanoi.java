package recursion;

import java.util.Scanner;

public class _7TowerOfHanoi {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int t1 = scn.nextInt();
        int t2 = scn.nextInt();
        int t3 = scn.nextInt();
        tower(n,t1,t2,t3);
    }

    private static void tower(int n, int t1, int t2, int t3) {
        if (n == 0) return;
        tower(n-1,t1,t3,t2); // will move n-1 disk from t1 to t3 using t2
        System.out.println(n + "[ " + t1 + "->" + t2 + " ]");
        tower(n-1,t3,t2,t1);
    }
}
