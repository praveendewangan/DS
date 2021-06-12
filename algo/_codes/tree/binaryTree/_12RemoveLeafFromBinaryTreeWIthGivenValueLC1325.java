public class _12RemoveLeafFromBinaryTreeWIthGivenValueLC1325 {
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
    public TreeNode removeLeafNodes(TreeNode node, int target) {
        if(node == null) return node;
        removeLeafNodes(node.left,target);
        removeLeafNodes(node.right,target);
        if(node.left != null && node.left.left == null && node.left.right == null){
            if(node.left.val == target) {
                node.left = null;
            }
        }
        if(node.right != null && node.right.left == null && node.right.right == null){
            if(node.right.val == target) {
                node.right = null;
            }
        }
        if(node.left == null && node.right == null && node.val == target) return null;
        return node;
    }
}
