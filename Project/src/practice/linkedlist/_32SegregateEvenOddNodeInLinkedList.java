package practice.linkedlist;

public class _32SegregateEvenOddNodeInLinkedList {
    // O(n),O(N)
    Node divide(int N, Node head){
        if(head == null || head.next == null){
            return head;
        }
        
        Node dummyEven = new Node(-1);
        Node dummyOdd = new Node(-1);
        Node even = dummyEven;
        Node odd = dummyOdd;
        Node cur = head;
        while(cur != null){
            if(cur.data % 2 != 0) {
                odd.next = cur;
                odd = odd.next;
            } else {
                even.next = cur;
                even = even.next;
            }
                cur = cur.next;
        }
        odd.next = null;
        even.next = dummyOdd.next;
        return dummyEven.next;
    }   
}
