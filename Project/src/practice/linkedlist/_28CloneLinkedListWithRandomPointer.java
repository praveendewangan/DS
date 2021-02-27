package practice.linkedlist;

public class _28CloneLinkedListWithRandomPointer {
    // O(n),O(1)
    Node copyList(Node head) {
        Node itr = head;
        Node front = head;
        while(itr != null){
            front = itr.next;
            Node copy = new Node(itr.data);
            itr.next = copy;
            copy.next = front;
            itr = front;
        }

        itr = head;
        while(itr != null) {
            if(itr.arb != null) {
                itr.next.arb = itr.arb.next;
            }
            itr = itr.next.next;
        }
        itr = head;
        Node node = new Node(0);
        Node copy = node;
        while(itr != null) {
            front = itr.next.next;
            copy.next = itr.next;
            copy = copy.next;
            itr.next = front;
            itr = front;
        }
        return node.next;
    }
}
