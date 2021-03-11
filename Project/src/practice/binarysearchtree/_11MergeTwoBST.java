package practice.binarysearchtree;

public class _11MergeTwoBST {
    // O(n),O(n)
    
    public Node mergeTrees(Node node1, Node node2) {
        if(node1 == null && node2 == null){
            return null;
        }
        int val = (node1 != null ? node1.data : 0) + (node2 != null ? node2.data : 0);
        Node node = new Node(val);
        node.left = mergeTrees(node1 != null ? node1.left : null,node2 != null ? node2.left : null);
        node.right = mergeTrees(node1 != null ? node1.right : null,node2 != null ? node2.right : null);
        return node;
    }
}
