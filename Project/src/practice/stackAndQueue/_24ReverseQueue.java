package practice.stackAndQueue;
import java.util.*;
public class _24ReverseQueue {
    // O(n),O(1)
    public Queue<Integer> rev(Queue<Integer> q){
        if(q.size() == 0){
            return q;
        }
        int rm = q.remove();
        rev(q);
        q.add(rm);
       return q;
    }
}
