package practice.linkedlist;

public class _4RemoveLoopInLinkedList2 {
    // O(n),O(1)
    public static void removeLoop(Node head){
        if(head==null) return;
        
        Node fast = head.next;
        Node slow = head;
        
        while( fast != slow )
        {
            if( fast==null || fast.next==null ) return;
            fast = fast.next.next;
            slow = slow.next;
        }
        
        int size = 1;
        fast = fast.next;
        while( fast != slow )
        {
            size += 1;
            fast = fast.next;
        }
        
        slow = head;
        fast = head;
        for(int i=0; i<size-1; i++)
            fast = fast.next;
        
        while( fast.next != slow )
        {
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = null;
    }
}
