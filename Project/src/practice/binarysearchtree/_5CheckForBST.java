package practice.binarysearchtree;

public class _5CheckForBST {
    // O(n),O(h)
    class BSTPair {
        int min;
        int max;
        boolean isBst;
    }
    boolean isBST(Node node) {
        return helper(node).isBst;
    }
    BSTPair helper(Node node) {
        if(node == null) {
            BSTPair o = new BSTPair();
            o.min = Integer.MAX_VALUE;
            o.max = Integer.MIN_VALUE;
            o.isBst = true;
            return o;
        } 
        BSTPair lp = helper(node.left);
        BSTPair rp = helper(node.right);
        BSTPair o = new BSTPair();
        o.isBst = lp.isBst && rp.isBst && (node.data > lp.max && node.data < rp.min);
        o.min = Math.min(node.data,Math.min(lp.min,rp.min));
        o.max = Math.max(node.data,Math.max(lp.max,rp.max));
        return o;
    }
}
