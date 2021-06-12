public class _18BinaryTreeFromPreAndInOrder {
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
    int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length == 0 
           || inorder.length == 0 || preorder.length != inorder.length) return null;
        
        return helper(0,preorder,inorder,0,preorder.length - 1);
    }
    
    private TreeNode helper(int idx,int[] pre,int[] in,int start,int end) {
        if(start > end) return null;
        // int cur = pre[idx];
        int cur = pre[index++];
        TreeNode node = new TreeNode(cur);
        if(start == end) {
            return node;
        }
        int pos = search(in,cur);
        node.left = helper(idx+1,pre,in,start,pos-1);
        node.right = helper(idx+pos-start+1,pre,in,pos+1,end);
        return node;
    }
    
    private int search(int[] arr,int val) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == val) {
                return i;
            } 
        }
        return -1;
    }
    

}
