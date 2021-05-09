
    import java.io.*;
    import java.util.*;
    
public class _6NextGreaterElement2 {
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
       int[] res = new int[len];
       st.push(0);
       for(int i = 1; i < len; i++){
           while(!st.isEmpty() && arr[st.peek()] < arr[i]) {
               res[st.pop()] = arr[i];
           }
           st.push(i);
       }
       while(!st.isEmpty()) {
           res[st.pop()] = -1;
       }
       return res;
     }
    
    }
