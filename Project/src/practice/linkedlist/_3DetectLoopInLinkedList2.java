package practice.linkedlist;

public class _3DetectLoopInLinkedList2 {
    // O(n),O(1)
    public static class Node { 
        int data;
        Node next;
    }
    public static boolean detectLoop(Node head){
        Node f = head;
        Node s = head;
        while(f.next != null && f.next.next != null){
            f = f.next.next;
            s = s.next;
            if(f == s) {
                return true;
            }
        }
        return false;
    }
}
