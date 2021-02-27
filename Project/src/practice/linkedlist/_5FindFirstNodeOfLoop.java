package practice.linkedlist;

public class _5FindFirstNodeOfLoop {
    Node findFirst(Node head) {
        // If list is empty or has 
          // only one node without loop
        if (head == null || head.next == null) {
            return null;
        }

        Node slow = head, fast = head;

        // Move slow and fast 1 
        // and 2 steps ahead 
        // respectively.
        slow = slow.next;
        fast = fast.next.next;

        // Search for loop using 
        // slow and fast pointers
        while (fast != null && 
            fast.next != null) 
        {
        if (slow == fast)
            break;
        slow = slow.next;
        fast = fast.next.next;
        }

        // If loop does not exist
        if (slow != fast) {
            return null;
        }

        // If loop exists. Start slow from
        // head and fast from meeting point.
        slow = head;
        while (slow != fast) 
        {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }   
}
