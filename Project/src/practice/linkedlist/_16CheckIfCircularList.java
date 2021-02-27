package practice.linkedlist;

public class _16CheckIfCircularList {
    // O(n),O(1);
    boolean isCircular(Node head)
    {
	    Node temp = head;
	    while(head != null) {
	        head = head.next;
	        if(temp == head) {
	            return true;
	        }
	    }
	    return false;
    }
}
