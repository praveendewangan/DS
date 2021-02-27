package practice.linkedlist;

public class _10AddTwoNumberInList2 {
    // O(n+m),O(max(o,m))

    static Node addTwoLists(Node first, Node second){
        first = reverseList(first);
        second = reverseList(second);
        Node node = null;
        int carry = 0;
        while(first != null || second != null || carry != 0) {
            int val = carry;
            
            if(first != null) val+=first.data;
            if(second != null) val+=second.data;
            
            int nd = val % 10;
            carry = val / 10;
            Node newNode = new Node(nd);
            newNode.next = node;
            node = newNode;
            
            if(first != null) first=first.next;
            if(second != null) second=second.next;
        }
        return node;
    }
    
    static Node reverseList(Node node) {
        Node prev = null;
        Node cur = node;
        Node next = null;
        while(cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        node = prev;
        return node;
    }
 
}
