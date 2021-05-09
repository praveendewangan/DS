
    import java.io.*;
    import java.util.*;
    public class _9NextSmallerElementLeft {
        public static void display(int[] a){
            StringBuilder sb = new StringBuilder();
        
            for(int val: a){
              sb.append(val + "\n");
            }
            System.out.println(sb);
          }
        
        public static void main(String[] args) throws Exception {
            int[] res = solve(new int[] {10,6,12,5,3,2,4,8,1});
            display(res);
        }
        public static int[] solve(int[] arr){
            Stack<Integer> st = new Stack<>();
            int len = arr.length;
            int[] res = new int[len];
            
           st.push(len - 1);
           for(int i = len - 2; i >= 0; i--){
               while(!st.isEmpty() && arr[st.peek()] > arr[i]) {
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
    
