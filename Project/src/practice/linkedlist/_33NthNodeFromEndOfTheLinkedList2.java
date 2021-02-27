package practice.linkedlist;

public class _33NthNodeFromEndOfTheLinkedList2 {
    // O(n),O(1)
    int getNthFromLast(Node head, int n)
    {
        Node node = head,nthNode = head;
        while(n != 0) {
            if(node == null) {
                return -1;
            } 
            node = node.next;
            n--;
        }
        while(node != null){
            node = node.next;
            nthNode = nthNode.next;
        }
        if(nthNode == null){
            return -1;
        }
    	return nthNode.data;
    }
}
