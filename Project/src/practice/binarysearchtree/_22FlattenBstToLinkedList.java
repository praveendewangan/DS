package practice.binarysearchtree;

public class _22FlattenBstToLinkedList {
    // O(n),O(1)
    Node prev = null;
    public void flatten(Node root) {
        if(root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
        
        
    }
}
