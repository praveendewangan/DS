package practice.binarytree;

public class _18BinaryTreeToDLL {
    // O(n),O(n)
    Node prev = null;
    Node head;
    Node bToDLL(Node root)
    {
        bToDLLHelper(root);
	    return head;	
    }
    void bToDLLHelper(Node node) {
        if(node == null) return;
        
        bToDLLHelper(node.left);
        if(prev == null){
            head = node;
        } else {
            node.left = prev;
            prev.right = node;
        }
            prev = node;
        bToDLLHelper(node.right);
    }
}
