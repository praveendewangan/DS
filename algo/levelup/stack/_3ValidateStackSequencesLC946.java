import java.io.*;
import java.util.*;

public class _3ValidateStackSequencesLC946 {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int idx = 0;
        for(int val : pushed) {
            st.push(val);
            while(st.size() > 0 && st.peek() == popped[idx]) {
                st.pop();
                idx++;
            }
        }
        return st.isEmpty();
    }

    public static int[] getArr(String s){
        String nums[] = s.split(" ");
        int n = nums.length;
        int ar[] = new int[n];
        for(int i=0;i<n;i++){
            ar[i] = Integer.parseInt(nums[i]);
        }
        return ar;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int pushed [] = getArr(read.readLine());
        int popped [] = getArr(read.readLine());
        
        boolean result = validateStackSequences(pushed, popped);

        System.out.println(result);
    }
}