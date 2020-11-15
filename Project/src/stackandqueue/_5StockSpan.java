package stackandqueue;

import java.util.Scanner;
import java.util.Stack;

public class _5StockSpan {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n =  scn.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }
        solve(a);
    }
    private static int[] solve(int[] a) {
        int[] res = new int[a.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        res[0] = 1;
        for (int i = 1; i < a.length ; i--) {
            while (st.size() > 0 && a[i] >= a[st.peek()]) {
                st.pop();
            }
            if(st.size() == 0) {
                res[i] = i + 1;
            } else {
                res[i] = i - st.peek();
            }
            st.push(i);
        }
        return res;
    }
}
