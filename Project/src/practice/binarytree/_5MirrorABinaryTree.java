package practice.binarytree;

public class _5MirrorABinaryTree {
    // O(n),O(1)
    public Node invertTree(Node root) {
        if(root == null) {
            return root;
        }
        Node left = invertTree(root.left);
        Node right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
