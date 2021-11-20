import java.util.Scanner;

public class _2ConstructBinaryTreeFromPostorderAndInorder {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
        
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length != inorder.length) {
            return null;
        }
        return helper(postorder,inorder,0,postorder.length-1,0,inorder.length-1);
    }
    
    private static TreeNode helper(int[] post,int[] in,int postSt,int postEnd,int inSt,int inEnd) {
        if(postSt > postEnd) {
            return null;
        }
        TreeNode node = new TreeNode(post[postEnd]);
        int idx = inSt;
        int pos = getPos(post[postEnd],in,idx);
        int eleCount = pos - inSt;
        node.left = helper(post,in,postSt,postSt+eleCount-1,inSt,pos-1);
        node.right = helper(post,in,postSt+eleCount,postEnd-1,pos+1,inEnd);
        return node;
    }
    
    private static int getPos(int val,int[] in,int idx) {
        for(int i = idx; i < in.length; i++) {
            if(in[i] == val) {
                return i;
            }
        }
        return -1;
    }

    // input_section=================================================

    public static void display(TreeNode node) {
        if (node == null)
            return;

        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append(" -> " + node.val + " <- ");
        sb.append((node.right != null ? node.right.val : "."));

        System.out.println(sb.toString());

        display(node.left);
        display(node.right);

    }

    public static void solve() {
        int n = scn.nextInt();
        int[] post = new int[n];
        for (int i = 0; i < n; i++)
            post[i] = scn.nextInt();

        int[] in = new int[n];
        for (int i = 0; i < n; i++)
            in[i] = scn.nextInt();

        TreeNode root = buildTree(in, post);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}