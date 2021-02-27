package practice.linkedlist;

public class _31DeleteNodeHavingGreaterValueToTheRight2 {
    // O(n),O(1);
    Node reverse(Node head) {
        Node cur = head;
        Node prev = null;
        Node next = null;
        while(cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
    Node compute(Node head)
    {
        Node reverse = reverse(head);
        Node temp = reverse;
        int max = temp.data;
        while(temp.next != null) {
            if(temp.next.data >= max) {
                max = temp.next.data;
                temp = temp.next;
            } else {
                temp.next = temp.next.next; 
            }
        }
        reverse = reverse(reverse);
        return reverse;
    }
}
