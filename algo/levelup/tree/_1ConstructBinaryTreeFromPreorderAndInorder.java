import java.util.Scanner;

public class _1ConstructBinaryTreeFromPreorderAndInorder {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length != inorder.length) {
            return null;
        }
        return helper(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }
    
    private static TreeNode helper(int[] pre,int[] in,int preSt,int preEnd,int inSt,int inEnd) {
        if(preSt > preEnd) {
            return null;
        }
        TreeNode node = new TreeNode(pre[preSt]);
        // if(preSt == preEnd) {
        //     return node;
        // }
        int idx = inSt;
        int pos = getPos(pre[preSt],in,idx);
        int eleCount = pos - inSt;
        node.left = helper(pre,in,preSt+1,preSt+eleCount,inSt,pos-1);
        node.right = helper(pre,in,preSt+eleCount+1,preEnd,pos+1,inEnd);
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
        int[] pre = new int[n];
        for (int i = 0; i < n; i++)
            pre[i] = scn.nextInt();

        int[] in = new int[n];
        for (int i = 0; i < n; i++)
            in[i] = scn.nextInt();

        TreeNode root = buildTree(pre, in);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}