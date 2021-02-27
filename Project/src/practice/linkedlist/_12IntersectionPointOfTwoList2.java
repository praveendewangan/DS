package practice.linkedlist;

public class _12IntersectionPointOfTwoList2 {
    // O(m),O(1)
    int intersectPoint(Node head1, Node head2)
	{
         Node n1 = head1;
         Node n2 = head2;
         while(n1 != n2){
             n1 = n1 == null ? head2 : n1.next;
             n2 = n2 == null ? head1 : n2.next;
         }
         if(n1 == null) return -1;
         return n1.data;
	}
}
