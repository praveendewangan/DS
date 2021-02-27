package practice.linkedlist;

public class _11IntersectionOfTwoSOrtedList {
    // O(n+m),O(max(m,n))
    public static Node findIntersection(Node head1, Node head2)
    {
        Node temp = new Node(0);
        Node node = temp;
        while(head1 != null && head2 != null) {
            if(head1.data > head2.data){
                head2 = head2.next;
            } else if(head1.data < head2.data) {
                head1 = head1.next;
            } else {
                temp.next = new Node(head1.data);
                temp = temp.next;
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        return node.next;
    }
}
