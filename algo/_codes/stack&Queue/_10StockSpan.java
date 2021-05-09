
import java.io.*;
import java.util.*;

public class _10StockSpan {
    
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
    
        int[] span = solve(a);
        display(span);
     }
    
     public static int[] solve(int[] arr){
            Stack<Integer> st = new Stack<>();
            int len = arr.length;
            int[] res = new int[len];
            st.push(len-1);
            for(int i = len - 2; i >= 0; i--){
                while(!st.isEmpty() && arr[st.peek()] < arr[i]) {
                    res[st.pop()] = i;
                }
                st.push(i);
            }
            while(!st.isEmpty()) {
                res[st.pop()] = -1;
            }
            for(int i = 0; i < arr.length; i++){
                res[i] =  i - res[i];
            }
            return res;
     }
      
}
