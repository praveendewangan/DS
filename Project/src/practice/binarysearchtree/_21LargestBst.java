package practice.binarysearchtree;

public class _21LargestBst {
    // O(n),O(h)
    static int largestBst(Node root)
    {
        return isBST(root).size;
    }
    public static class BSTPair {
        boolean isBST;
        int min;
        int max;
        int size;
    }
    public static BSTPair isBST(Node node){
        if(node == null) {
            BSTPair bp = new BSTPair();
            bp.min = Integer.MAX_VALUE;
            bp.max = Integer.MIN_VALUE;
            bp.isBST = true;
            return bp;
        }

        BSTPair lbp = isBST(node.left);
        BSTPair rbp = isBST(node.right);

        BSTPair mp = new BSTPair();
        mp.isBST = lbp.isBST && rbp.isBST && (node.data > lbp.max && node.data < rbp.min);
        mp.min = Math.min(node.data,Math.min(lbp.min,rbp.min));
        mp.max = Math.max(node.data,Math.max(lbp.max,rbp.max));
        if(mp.isBST) {
            mp.size = lbp.size + rbp.size + 1;
        } else if(lbp.size > rbp.size) {
            mp.size = lbp.size;
        } else {
            mp.size = rbp.size;
        }
        return mp;
    }
    
}
