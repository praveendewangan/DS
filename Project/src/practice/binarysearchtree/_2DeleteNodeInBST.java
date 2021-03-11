package practice.binarysearchtree;

public class _2DeleteNodeInBST {
    // O(h),O(1)
    public Node deleteNode(Node root, int key) {
        return solve(root,key);
    }
    public Node solve(Node node,int key) {
        if(node == null) {
            return null;
        }
        if(node.data < key) {
            node.right = solve(node.right,key);
        } else if(node.data > key) {
            node.left = solve(node.left,key);
        } else {
            if(node.left != null && node.right != null) {
                int max = getMax(node.left);
                node.data = max;
                node.left = solve(node.left,max);
            } else if(node.left != null) {
                return node.left;
            } else if(node.right != null) {
                return node.right;
            } else {
                return null;
            }
        }
        return node;
    }
    public int getMax(Node node) {
        if(node.right != null) {
            return getMax(node.right);
        } else {
            return node.data;
        }
    }
}
