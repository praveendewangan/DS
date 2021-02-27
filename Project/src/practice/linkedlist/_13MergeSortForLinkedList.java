package practice.linkedlist;

public class _13MergeSortForLinkedList {
    // O(nlogn),O(n)
    static Node mergeSort(Node head)
    {
        if(head == null || head.next == null) {
            return head;
        }
        Node middle = middleNode(head);
        Node temp = middle.next;
        middle.next = null;
        return merge(mergeSort(head),mergeSort(temp));
    }
    static Node middleNode(Node node) {
        if(node == null) return node;
        Node s = node;
        Node f = node;
        while(f.next != null && f.next.next != null) {
            s = s.next;
            f = f.next.next;
        }
        return s;
    }
    static Node merge(Node n1,Node n2) {
        Node temp = new Node(0);
        Node node = temp;
        while(n1 != null && n2 != null) {
            if(n1.data < n2.data) {
                temp.next = n1;
                n1 = n1.next;
            } else {
                temp.next = n2;
                n2 = n2.next;
            } 
            temp = temp.next;
        }
        temp.next = (n1==null) ? n2 : n1;
        return node.next;
    }   
}
