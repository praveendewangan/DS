package practice.linkedlist;

public class _15MiddleOfList2 {
    // O(n) , O(1)
    public Node middleNode(Node head) {
        if(head == null || head.next == null) {
            return head;
        }
        Node s = head;
        Node f = head;
        while(f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }
        return s; 
    }   
}
