package practice.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class _4RemoveLoopInLinkedList {
    // O(n),O(n)
    public static void removeLoop(Node node){
        Set<Node> set = new HashSet<>();
        Node prev = null;
        while(node != null){
            if(set.contains(node)){
                prev.next = null;
                break;
            } else {
                set.add(node);
                prev = node;
                node = node.next; 
            }
        }
        
    }
}
