package dynamicprograms;

import java.util.Scanner;

public class _2ClimbingStairs {
    private static int pathsMemo(int n,int[] qb) {
        if(n == 0) {
            return 1;
        } else if(n < 0) {
            return 0;
        }
        if(qb[n] != 0) {
            return qb[n];
        }
        int p1 = pathsMemo(n - 1,qb);
        int p2 = pathsMemo(n - 2,qb);
        int p3 = pathsMemo(n - 3,qb);
        int path = p1 + p2 + p3;
        qb[n] = path;
        return path;
    }
    private static int pathsTabulation(int n) {
        int[] qb = new int[n+1];
        qb[0] = 1;
        for (int i = 1; i <= n ; i++) {
            if(i == 1) {
                qb[i] = qb[i - 1];
            } else if(i == 2) {
                qb[i] = qb[i - 1] + qb[i - 2];
            } else {
                qb[i] = qb[i - 1] + qb[i - 2] + qb[i - 3];
            }
        }
        return qb[n];
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n =  scn.nextInt();
        System.out.println(pathsMemo(n,new int[n+1]));
        System.out.println(pathsTabulation(n));
    }
}
