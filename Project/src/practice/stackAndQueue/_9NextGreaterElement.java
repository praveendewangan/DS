package practice.stackAndQueue;

import java.util.Stack;

public class _9NextGreaterElement {
    // O(n),O(n)

    public static long[] nextLargerElement(long[] arr, int n) { 
        long[] a = new long[n];
        a[n-1] = -1L;
        Stack<Long> st = new Stack<>();
        st.push(arr[n-1]);
        for(int i=n-2;i >= 0;i--){
                while(st.size() != 0 && arr[i] > st.peek()) {
                    st.pop();
                }
                if(st.size() == 0) {
                    a[i] = -1L;
                } else {
                    a[i] = st.peek();
                }
                st.push(arr[i]);
        }
        return a;
    } 
}
