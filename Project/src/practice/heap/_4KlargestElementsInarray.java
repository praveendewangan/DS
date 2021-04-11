package practice.heap;
import java.util.*;

public class _4KlargestElementsInarray {
    // O(n),O(k)
//  Arrays.sort(arr, Collections.reverseOrder());
    int[] kLargest(int[] arr, int n, int k) {
        Queue<Integer> q = new PriorityQueue<>();
        for(int i=0;i < n;i++){
            if( i < k) {
                q.add(arr[i]);
            } else {
                if(arr[i] > q.peek()){
                    q.remove();
                    q.add(arr[i]);
                }
            }
        }
        int[] a = new int[k];
        int idx = 0;
        Stack<Integer> st = new Stack<>();
        
        while(q.size() > 0){
            st.push(q.remove());
        }
        while(st.size() > 0){
            a[idx++] = st.pop();
        }
        return a;
    }
}
