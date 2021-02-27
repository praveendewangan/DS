package practice.linkedlist;

public class _33NthNodeFromEndOfTheLinkedList {
    // O(n),O(1)
    int getSize(Node node) {
        int count = 0;
        Node temp = node;
        while(temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
    int getNthFromLast(Node head, int n)
    {
        int size = getSize(head);
        if(n > size){
            return -1;
        }
        for(int i=0;i<size-n;i++){
            head = head.next;
        }
    	return head.data;
    }
}
