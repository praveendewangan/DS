package practice.stackAndQueue;

import java.util.Stack;

public class _16LargestAreaHistogram {
    // O(n),O(n)
    public static long getMaxArea(long hist[], long n)  {
        long max = Long.MIN_VALUE;
        long[] ra = new long[hist.length];
        ra[hist.length-1] = n;
        Stack<Integer> st = new Stack<>();
        st.push(hist.length-1);
        for(int i=hist.length-2; i >= 0; i--) {
            while(st.size() > 0 && hist[i] <= hist[st.peek()]) {
                st.pop();
            } 
            if(st.size() == 0) {
                ra[i] = n;
            } else {
                ra[i] = st.peek();
            }
            st.push(i);
        }
        st = new Stack<>();
        st.push(0);
        long[] la = new long[hist.length];
        la[0] = -1;
        for(int i=1; i < hist.length; i++) {
            while(st.size() > 0 && hist[i] <= hist[st.peek()]) {
                st.pop();
            } 
            if(st.size() == 0) {
                la[i] = -1;
            } else {
                la[i] = st.peek();
            }
            st.push(i);
        }
        
        for(int i=0; i < hist.length; i++){
            long width = ra[i] - la[i] - 1;
            long area = hist[i] * width;
            if(max < area) {
                max = area;
            }
        }
        return max;
    }

}
