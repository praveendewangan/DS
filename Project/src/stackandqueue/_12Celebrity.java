package stackandqueue;

import java.util.Scanner;
import java.util.Stack;

/*
    Input : 5
*    0 1 1 1 1
*    1 0 0 1 0
*    1 0 0 1 0
*    0 0 0 0 0
*    0 1 0 1 0
    Output  : 3
* */
public class _12Celebrity {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] a = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scn.nextInt();
            }
        }

        findCelebrity(a);
    }

    private static void findCelebrity(int[][] a) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < a.length; i++) {
            st.push(i);
        }

        while (st.size() >= 2) {
            int i = st.pop();
            int j = st.pop();
            if(a[i][j] == 1) {
                st.push(j);
            } else {
                st.push(i);
            }
        }
        int pt = st.pop();
        for (int i = 0; i < a.length; i++) {
            if(i != pt) {
                if(a[i][pt] == 0 || a[pt][i] == 1) {
                    System.out.println("none");
                    return;
                }
            }
        }
        System.out.println("Celebrity -> "+pt);
    }
}
