package practice.linkedlist;

public class _12IntersectionPointOfTwoList {
    // O(m),O(1)
    int intersectPoint(Node head1, Node head2)
	{
         int s1 = getSize(head1);
         int s2 = getSize(head2);
         if(s1 > s2){
             for(int i=0;i<(s1-s2);i++) {
                 head1 = head1.next;
             }
         } else {
             for(int i=0;i<(s2-s1);i++) {
                 head2 = head2.next;
             }
         }
         while(head1 != null && head2 != null) {
             if(head1 == head2) {
                 return head1.data;
             }
             head1 = head1.next;
             head2 = head2.next;
         }
         return -1;
	}
	int getSize(Node node) {
	    int count = 1;
	    while(node != null) {
	        count++;
	        node = node.next;
	    }
	    return count;
	}
}
