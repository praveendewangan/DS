public class _15IsBinarySearchTreeLc98 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public boolean isValidBST(TreeNode root) {
        return isBst(root,null,null);
    }
    private boolean isBst(TreeNode node,TreeNode min,TreeNode max) {
        if(node == null) return true;
        if(min != null && node.val <= min.val) {
            return false;
        }
        if(max != null && node.val >= max.val) {
            return false;
        }
        boolean flag = isBst(node.left,min,node);
        return flag && isBst(node.right,node,max);
    }
}
