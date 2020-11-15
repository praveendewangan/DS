package stackandqueue;

import java.util.Scanner;
import java.util.Stack;

public class _7SlidingWindowMaximum {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int k = scn.nextInt();
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }
        int[] res = new int[a.length];
        Stack<Integer> st = new Stack<>();
        st.push(a.length - 1);
        res[a.length - 1] = a.length;
        for (int i = a.length - 2; i >= 0 ; i--) {
            while (st.size() > 0 && a[i] >= a[st.peek()]) {
                st.pop();
            }
            if(st.size() == 0) {
                res[i] = a.length;
            } else {
                res[i] = st.peek();
            }
            st.push(i);
        }
        int j = 0;
        for (int i = 0; i <= a.length - k; i++) {
            if(j < i) {
                j = i;
            }
            while (res[j] < i + k) {
                j = res[j];
            }
            System.out.println(a[j]);
        }
    }
}
