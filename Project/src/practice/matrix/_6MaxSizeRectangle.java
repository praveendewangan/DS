package practice.matrix;

import java.util.Stack;

public class _6MaxSizeRectangle {
    // Approch 1 O(n),O(n)
    public int maxArea(int M[][], int m, int n) {
        int ans = getArea(M[0]);
        for(int i=1;i<M.length;i++){
            for(int j=0;j<M[0].length;j++) {
                if(M[i][j] == 1){
                    M[i][j] += M[i-1][j];
                }
            }
            int temp = getArea(M[i]);
            ans = Math.max(ans,temp);
        }
        return ans;
    }
    
    public int getArea(int[] a){
        int ans = 0;
        int[] rb = new int[a.length];
        rb[a.length-1] = a.length-1;
        Stack<Integer> st = new Stack<>();
        st.push(a.length-1);
        for(int i=a.length-2;i>=0;i--) {
            while(st.size() > 0 && a[i] <= a[st.peek()]) {
                st.pop();
            }
            if(st.size() == 0) {
                rb[i] = 1;
            } else {
                rb[i] = st.peek()-1;
            }
            st.push(i);
        }
        st = new Stack<>();
        st.push(0);
        int[] lb = new int[a.length];
        lb[0] = 0;
        
        for(int i=0;i<a.length;i++) {
            while(st.size() > 0 && a[i] <= a[st.peek()]) {
                st.pop();
            }
            if(st.size() == 0) {
                lb[i] = 0;
            } else {
                lb[i] = st.peek()+1;
            }
            st.push(i);
        }
        for(int i=0;i<a.length;i++) {
            int width = rb[i] - lb[i] + 1;
            int area = a[i] * width;
            if(area > ans) {
                ans = area;
            }
        }
        return ans;
    }
}
