
public class _19BinaryTreeFromPostAndInOrder {
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder == null || inorder == null || postorder.length == 0 
           || inorder.length == 0 || postorder.length != inorder.length) return null;
        index = postorder.length-1;
        return helper(postorder,inorder,0,postorder.length-1);
    }
    
    private TreeNode helper(int[] post,int[] in,int start,int end) {
        if(start > end) return null;
        // int cur = post[idx];
        int cur = post[index--];
        TreeNode node = new TreeNode(cur);
        if(start == end) {
            return node;
        }
        int pos = search(in,cur,start,end);
        node.right = helper(post,in,pos+1,end);
        node.left = helper(post,in,start,pos-1);
        return node;
    }

    private int search(int[] arr,int val,int start,int end) {
        for(int i = start; i <= end; i++) {
            if(arr[i] == val) {
                return i;
            } 
        }
        return -1;
    }

}
