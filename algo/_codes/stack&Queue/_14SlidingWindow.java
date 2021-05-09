
import java.io.*;
import java.util.*;

public class _14SlidingWindow {
    
    
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            for(int i = 0; i < n; i++){
               a[i] = Integer.parseInt(br.readLine());
            }
            int k = Integer.parseInt(br.readLine());
        
            solve(a,k);
         }
         
         private static void solve(int[] arr,int k) {
             int[] rgi = ngr(arr);
             int j = 0;
             for(int i = 0; i <= arr.length - k; i++) {
                 if(i > j) {
                     j = i;
                 }
                 while(i + k > rgi[j]) {
                     j = rgi[j];
                 }
                 System.out.println(arr[j]);
             }
         }
         public static int[] ngr(int[] arr){
           Stack<Integer> st = new Stack<>();
           int len = arr.length;
           int[] res = new int[len];
           st.push(0);
           for(int i = 1; i < len; i++){
               while(!st.isEmpty() && arr[st.peek()] < arr[i]) {
                   res[st.pop()] = i;
               }
               st.push(i);
           }
           while(!st.isEmpty()) {
               res[st.pop()] = arr.length;
           }
           return res;
         }
        
     
    }
