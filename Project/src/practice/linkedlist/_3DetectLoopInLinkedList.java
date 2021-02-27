package practice.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class _3DetectLoopInLinkedList {
    // O(n),O(n)
    public static class Node {
        int data;
        Node next;
    }
    public static boolean detectLoop(Node head){
        Set<Node> set = new HashSet<>();
        Node cur = head;
        while(cur != null) {
            if(set.contains(cur)){
                return true;
            } else {
                set.add(cur);
                cur = cur.next;
            }
        }
        return false;
    }
}
