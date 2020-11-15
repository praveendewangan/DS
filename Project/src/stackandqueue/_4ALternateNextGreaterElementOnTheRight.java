package stackandqueue;

import java.util.Scanner;
import java.util.Stack;

public class _4ALternateNextGreaterElementOnTheRight {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }
        int[] res = solve(a);
        for (int val : res) {
            System.out.print(val + " ");
        }
    }
    private static int[] solve(int[] a) {
        int[] res = new int[a.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for (int i = 1; i < a.length ; i++) {
            while (st.size() > 0 && a[i] >= a[st.peek()]) {
                int pos = st.peek();
                res[pos] = a[i];
                st.pop();
            }
            st.push(i);
        }
        while (st.size() > 0) {
            int pos = st.peek();
            res[pos] = -1;
            st.pop();
        }
        return res;
    }
}
