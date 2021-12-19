import java.io.*;
import java.util.*;

public class _11OneThreeTwoPatternLC456 {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] nums = new int[n];
        for(int i=0; i < n; i++) {
            nums[i] = scn.nextInt();
        }
        
        int[] min = new int[n];
        min[0] = nums[0];
        for(int i=1; i < n; i++){
            min[i] = Math.min(min[i-1],nums[i]);
        }
        
        Stack<Integer> st = new Stack<>();
        boolean found = false;
        for(int j=n-1; j >= 0; j--) {
            while(st.size() > 0 && st.peek() <= min[j]) {
                st.pop();
            }
            if(st.size() > 0 && st.peek() < nums[j]) {
                found = true;
                break;
            }
            st.push(nums[j]);
        }
        System.out.println(found);
    }
}
