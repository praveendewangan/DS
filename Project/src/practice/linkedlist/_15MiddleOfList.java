package practice.linkedlist;

public class _15MiddleOfList {
    // O(n),O(1)
    public Node middleNode(Node head) {
        if(head == null || head.next == null) {
            return head;
        }
        Node temp = head;
        int size = getSize(temp);
        Node s = head;
        Node f = head;
        while(f.next != null && f.next.next != null) {
            s = s.next;
            f = f.next.next;
        }
        if(size % 2 == 0){
            return s.next;
        } else {
            return s;  
        } 
    }
    public int getSize(Node head) {
        int count = 0;
        while(head != null) {
            count++;
            head = head.next; 
        }
        return count;
    }

}
