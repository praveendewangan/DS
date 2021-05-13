import java.util.*;
public class _6NextGreaterElementCircular3LC503 {
    // Input: nums = [1,2,1]
    // Output: [2,-1,2]    
    public int[] nextGreaterElements(int[] nums) {
        
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
}
