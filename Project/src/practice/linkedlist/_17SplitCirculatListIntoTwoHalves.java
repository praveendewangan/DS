package practice.linkedlist;

public class _17SplitCirculatListIntoTwoHalves {
    // O(n),O(1)
    public static class circular_LinkedList {
        Node head1;
        Node head2;
        Node head;
    }
    void splitList(circular_LinkedList list)
        {
                Node s = list.head;
                Node f = list.head;
                while( f.next != list.head && f.next.next != list.head){
                    s = s.next;
                    f = f.next.next;
                }
                if(f.next.next == list.head) {
                    f = f.next;
                } 
                list.head1 = list.head;
                list.head2 = s.next;
                f.next = s.next;
                s.next = list.head;
	    }
}
