package practice.binarytree;

public class _14CheckForBalanceTree {
    // O(n),O(h) h == height of the tree
    class BalPair {
        int ht;
        boolean isBal;
    }
    boolean isBalanced(Node root)
    {
        return isBal(root).isBal;
    }
    BalPair isBal(Node root) {
        if(root == null) {
            BalPair o = new BalPair();
            o.ht = 0;
            o.isBal = true;
            return o;
        }
        BalPair lp = isBal(root.left);
        BalPair rp = isBal(root.right);
        int ht = Math.max(lp.ht,rp.ht) + 1;
        BalPair o = new BalPair();
        o.ht = ht;
        o.isBal = Math.abs(lp.ht-rp.ht) <= 1 && lp.isBal && rp.isBal;
        return o;
    }
}
