import java.io.*;
import java.util.*;

public class _20NumberOfValidSubarrays {

  public static int validSubarrays(int[] nums) {
    int count = 0;

        // make a next smaller index in right 
        // int[] nsr = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < nums.length; i++) {
            while(st.size() > 0 && nums[st.peek()] > nums[i]) {
                // nsr[st.pop()] = i;
                count += i - st.pop();
            }
            st.push(i);
        }
        while(st.size() > 0) {
            // nsr[st.pop()] = nums.length;
            count += nums.length - st.pop();
        }
        // take contribution
        
        // for(int i = 0; i < nums.length; i++) {
        //     count += nsr[i] - i;
        // }
        return count;
  }
  

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(read.readLine());
    int nums[] = new int[n];
    for (int i = 0; i < n; i++) {
      nums[i] = Integer.parseInt(read.readLine());
    }

    int count = validSubarrays(nums);

    System.out.println(count);

  }
}
