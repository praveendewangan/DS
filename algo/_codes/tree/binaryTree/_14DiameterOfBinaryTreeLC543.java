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
public class _14DiameterOfBinaryTreeLC543 {
    int dia = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter(root);
        return dia;
    }
    private int diameter(TreeNode node) {
        if(node == null) return 0;
        int lh = diameter(node.left);
        int rh = diameter(node.right);
        dia = Math.max(dia,lh+rh);
        return Math.max(lh,rh) + 1;
    }
}
