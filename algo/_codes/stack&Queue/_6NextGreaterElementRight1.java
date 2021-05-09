
import java.io.*;
import java.util.*;

public class _6NextGreaterElement1 {
    public static void display(int[] a){
        StringBuilder sb = new StringBuilder();

        for(int val: a){
            sb.append(val + "\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(br.readLine());
        }

        int[] nge = solve(a);
        display(nge);
    }

    public static int[] solve(int[] arr){
        Stack<Integer> st = new Stack<>();
        int len = arr.length;
        int[] res = new int[arr.length];
        res[len - 1] = -1;
        st.push(arr[len-1]);
        for(int i = arr.length - 2; i >= 0; i--){
            int val = arr[i];
            if(!st.isEmpty() && st.peek() > val){
                res[i] = st.peek();
                st.push(val);
            } else {
                while(!st.isEmpty() && st.peek() < val){
                    st.pop();
                }
                if(!st.isEmpty()) {
                    res[i] = -1;
                } else {
                    res[i] = st.peek();
                }
                    st.push(val);
            }
        }
        return res;
    }

}
