package practice.stackAndQueue;

import java.util.Stack;

public class _33NextSmallerElement {
    
    public static void main(String[] args) {
        int arr[] = { 11, 13, 21, 3 };
        int n = arr.length;
        printNSE(arr, n);
    }
    private static void printNSE(int[] a,int n) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        for(int i = a.length-1; i >= 0; i--) {
            if(i == a.length-1 ){
                int num = st.peek();
                st.push(a[i]);
                a[i] = num;
            } else {
                while(!st.isEmpty()) {
                    if(a[i] > st.peek()){
                        int num = st.peek();
                        st.push(a[i]);
                        a[i] = num;
                        break;
                    } else {
                        st.pop();
                    }
                }
                if(st.isEmpty()){
                    st.push(a[i]);
                    a[i] = -1;
                }
            }
        }
        for(int val : a) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
