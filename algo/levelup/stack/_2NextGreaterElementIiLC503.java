import java.io.*;
import java.util.*;

public class _2NextGreaterElementIiLC503 {
    public static int[] nextGreaterElementII(int[] nums) {
         Stack<Integer> st = new Stack<>();
        st.push(0);
        int[] res = new int[nums.length];
        for(int i = 1; i < nums.length; i++) {
            while(!st.empty() && nums[st.peek()] < nums[i]) {
                res[st.pop()] = nums[i];
            }
            st.push(i);
        }
        while(!st.empty()) {
            int idx = st.pop();
            int val = -1;
            for(int i = 0; i < idx; i++){
                if(nums[i] > nums[idx]){
                    val = nums[i];
                    break;
                }
            }
            res[idx] = val;
        }
        return res;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(read.readLine());
        int nums[] = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = Integer.parseInt(read.readLine());
        }
        
        int ans[] = nextGreaterElementII(nums);

        n = ans.length;

        System.out.println(n);
        for(int e: ans){
            System.out.println(e);
        }
        
    }
}