
import java.io.*;
import java.util.*;

public class _12LargestAreaHistogram {


public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
        a[i] = Integer.parseInt(br.readLine());
    }
    int area = solve(a);
    System.out.println(area);
    }
    
    private static int solve(int[] arr) {
    int len = arr.length;
    int[] left = nsl(arr);
    int[] right = nsr(arr);
    
    int max = Integer.MIN_VALUE;
    for(int i = 0; i < len; i++){
        int width = right[i] - left[i] - 1;
        int area = width * arr[i];
        if(max < area) {
            max = area;
        }
    }
    return max;
    }
    
    private static int[] nsl(int[] arr) {
        int len = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] left = new int[len];
        st.push(len - 1);
        
    for(int i = len - 2; i >= 0; i--){
        while(!st.isEmpty() && arr[st.peek()] > arr[i]) {
            left[st.pop()] = i;
        }
        st.push(i);
    }
    while(!st.isEmpty()) {
        left[st.pop()] = -1;
    }
    return left;
    }
    private static int[] nsr(int[] arr) {
        int len = arr.length;
    Stack<Integer> st = new Stack<>();
    int[] right = new int[len];
        st.push(0);
        
    for(int i = 1; i < len; i++){
        while(!st.isEmpty() && arr[st.peek()] > arr[i]) {
            right[st.pop()] = i;
        }
        st.push(i);
    }
    while(!st.isEmpty()) {
        right[st.pop()] = len;
    }
    return right;
    }
}
