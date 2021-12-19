import java.io.*;
import java.util.*;

public class _21LexicographicallySmallestSubsequenceLC1673 {
  public static int[] smallest(int[] nums, int k) {
    Stack<Integer> st = new Stack<>();
    int n = nums.length; 
    for(int i=0; i < n; i++){
        int num = nums[i];
        while(st.size() > 0 && num < st.peek() && n-i-1 >= k-st.size()) {
            st.pop();
        }
        if(st.size() < k) {
            st.push(num);
        }
    }
    int[] ans = new int[st.size()];
    int i = ans.length-1;
    while(st.size() > 0) {
        ans[i--] = st.pop(); 
    }
    return ans;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(read.readLine());
    int arr[] = new int[n];
    for (int i = 0; i < n; i++)arr[i] = Integer.parseInt(read.readLine());
    int k = Integer.parseInt(read.readLine());
    int ans[] = smallest(arr, k);
    System.out.println(ans.length);

    for (int e : ans) {
      System.out.println(e);
    }

  }
}
