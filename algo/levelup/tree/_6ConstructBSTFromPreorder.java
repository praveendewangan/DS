import java.util.Scanner;

public class _6ConstructBSTFromPreorder {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode bstFromPreorder(int[] preorder) {
        
        return helper(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    private static int idx = 0;
    private static TreeNode helper(int[] pre,int leftRange,int rightRange) {
        if(idx >= pre.length || pre[idx] < leftRange || rightRange < pre[idx]) {
            return null;
        }
        int val = pre[idx++];
        TreeNode node = new TreeNode(val);
        
        node.left = helper(pre,leftRange,val);
        node.right = helper(pre,val,rightRange);
        return node;
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

        TreeNode root = bstFromPreorder(pre);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}