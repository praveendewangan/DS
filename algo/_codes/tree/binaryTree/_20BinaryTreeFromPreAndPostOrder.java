public class _20BinaryTreeFromPreAndPostOrder {
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
    
    int preIdx = 0;
    int postIdx = 0;
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        TreeNode node = new TreeNode(pre[preIdx++]);
        if(node.val != post[postIdx]) {
            node.left = constructFromPrePost(pre,post);
        }
        if(node.val != post[postIdx]) {
            node.right = constructFromPrePost(pre,post);
        }
        postIdx++;
        return node;
    }
}
