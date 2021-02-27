package practice.linkedlist;

public class _9AddOneToList {
    public static Node addOne(Node head) 
    { 
        int c = addOneToNode(head);
        if(c > 0) {
            Node node = new Node(c);
            node.next = head;
            return node;
        }
        return head;
    }
    private static int addOneToNode(Node node) {
        if(node == null) {
            return 1;
        }
        
        int res = node.data + addOneToNode(node.next);
        
        node.data = res % 10;
        return res / 10;
    }
}
