package practice.binarysearchtree;

import java.util.ArrayList;
import java.util.List;

public class _10ConvertNormalBstToBalancedBst2 {
    // O(nlogn),O(n)
    List<Node> sortedArr = new ArrayList<>();
    public Node balanceBST(Node root) {
        inorderTraverse(root);
        return sortedArrayToBST(0, sortedArr.size() - 1);
    }
    void inorderTraverse(Node root) {
        if (root == null) return;
        inorderTraverse(root.left);
        sortedArr.add(root);
        inorderTraverse(root.right);
    }
    Node sortedArrayToBST(int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        Node root = sortedArr.get(mid);
        root.left = sortedArrayToBST(start, mid - 1);
        root.right = sortedArrayToBST(mid + 1, end);
        return root;
    }
}
