import java.util.Scanner;

public class _7ConstructBSTFromPostorder {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    private static int idx = 0;
    public static TreeNode bstFromPostorder(int[] postorder) {
        idx = postorder.length-1;
        return helper(postorder,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    
    private static TreeNode helper(int[] post,int leftRange,int rightRange) {
        if(idx < 0 || post[idx] < leftRange || rightRange < post[idx]) {
            return null;
        }
        
        int val = post[idx--];
        TreeNode node = new TreeNode(val);
        
        node.right = helper(post,val,rightRange);
        node.left = helper(post,leftRange,val);
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

        TreeNode root = bstFromPostorder(pre);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}