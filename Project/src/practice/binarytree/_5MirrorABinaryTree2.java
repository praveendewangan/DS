package practice.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class _5MirrorABinaryTree2 {
    // O(n),O(1)
    public Node invertTree(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            Node temp = current.left;
            current.left = current.right;
            current.right = temp;
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return root;
    }
}
