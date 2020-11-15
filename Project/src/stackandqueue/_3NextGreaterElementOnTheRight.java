package stackandqueue;

import java.util.Scanner;
import java.util.Stack;

public class _3NextGreaterElementOnTheRight {
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
        res[a.length-1] = -1;
        Stack<Integer> st = new Stack<>();
        st.push(a[a.length-1]);
        for (int i = a.length - 2; i >= 0 ; i--) {
            while (st.size() > 0 && a[i] >= st.peek()) {
                st.pop();
            }
            if(st.size() == 0) {
                res[i] = -1;
            } else {
                res[i] = st.peek();
            }
            st.push(a[i]);
        }
        return res;
    }
}
