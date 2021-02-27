package practice.linkedlist;

public class _2ReverseLinkedListInGroup3 {
    // O(n),O(1)
    public static Node reverse(Node node, int k)
    {
        Node next = null;
        Node cur = node;
        Node prev = null;
        int count = 0;
        while(cur != null && count < k) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            count++;
        }
        
        if(next != null) {
            node.next = reverse(next,k);
        }
        return prev;
    }
}
