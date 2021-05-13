import java.util.*;
public class _6NextGreaterElementLC496 {
    
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[nums2.length];
        st.push(0);
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i = 0; i < nums2.length; i++){
            while(!st.empty() && nums2[st.peek()] < nums2[i]) {
                int idx = st.pop();
                res[idx] = nums2[i];
                mp.put(nums2[idx],nums2[i]);
            }
            st.push(i);
        }
        // while(!st.empty()) {
        //     res[st.pop()] = -1;
        // }
        
        for(int i = 0; i < nums1.length; i++) {
            nums1[i] = mp.getOrDefault(nums1[i],-1);
        }
        return nums1;
    }
}
