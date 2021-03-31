package practice.stackAndQueue;
import java.util.*;

public class _25ReverseFirstKElementsOfQueue {
    // O(n),O(L-K)
    public Queue<Integer> modifyQueue(Queue<Integer> q, int k)
    {
        reverse(q);
        Stack<Integer> st = new Stack<>();
        int n = q.size() - k;
        while(n != 0){
            st.push(q.remove());
            n--;
        }
        while(st.size() != 0){
            q.add(st.pop());
        }
        return q;
    }
    
    private void reverse(Queue<Integer> q) {
        if(q.size() == 0) {
            return;
        }
        int rm = q.remove();
        reverse(q);
        q.add(rm);
    }
}
