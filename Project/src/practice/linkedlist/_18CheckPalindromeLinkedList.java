package practice.linkedlist;

public class _18CheckPalindromeLinkedList {
    // O(n/2),O(1)
    boolean isPalindrome(Node head) 
    {
        Node s = head;
        Node f = head;
        while(f.next != null && f.next.next != null) {
            s = s.next;
            f = f.next.next;
        }
        
        s.next = reverse(s.next);
        
        s = s.next;
        
        while(s != null) {
            if(s.data != head.data) {
                return false;
            }
            s = s.next;
            head = head.next;
        }
        return true;
        
    }    
    Node reverse(Node head) {
        Node prev = null;
        Node next = null;
        Node cur = head;
        while(cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        
        return prev;
    } 
}
