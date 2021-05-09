import java.util.*;
// Leetcode 85
public class _13MaximumRectangle {
    public int maximalRectangle(char[][] matrix) {
        int len = matrix.length;
        if(len == 0 || matrix[0].length == 0) {
            return 0;
        }
        int res = Integer.MIN_VALUE;
        int[] a = new int[matrix[0].length];
        for(int i = 0;i < len; i++){
//             Prepare array for largest area histogram
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == '0') {
                    a[j] = 0;
                } else {
                    a[j] += matrix[i][j] - '0';
                }
            }
            res = Math.max(res,hostogram(a));
            
        }
        return res;
    }
    private static int hostogram(int[] arr) {
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
