package practice.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class _7RemoveDuplicateFromUnsortedList {
    // O(n),O(n)

    public Node removeDuplicates(Node head) 
    {
         Set<Integer> set = new HashSet<>();
         Node prev = null;
         Node cur = head;
         while(cur != null){
             if(set.contains(cur.data)){
                 prev.next = cur.next;
             } else {
                 set.add(cur.data);
                 prev = cur;
             }
             cur = cur.next;
             
         }
         return head;
    }
}
