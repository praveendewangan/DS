import java.util.Scanner;

public class _3ConstructBinaryTreeFromPreorderAndPostorder {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode constructFromPrePost(int[] pre, int[] post) {
        if(pre.length != post.length) {
            return null;
        }
        return helper(pre,post,0,pre.length-1,0,post.length-1);
    }
    
    private static TreeNode helper(int[] pre,int[] post,int preSt,int preEnd,int postSt,int postEnd) {
        if(preSt == preEnd) {
            return new TreeNode(pre[preSt]);
        }
        if(preSt > preEnd) {
            return null;
        }
        
        TreeNode node = new TreeNode(pre[preSt]);
        int ele = pre[preSt+1];
        int idx = postSt;
        while(post[idx] != ele) {
            idx++;
        }
        int eleCount = idx - postSt + 1;
        
        node.left = helper(pre,post,preSt+1,preSt+eleCount,postSt,idx);
        node.right = helper(pre,post,preSt+eleCount+1,preEnd,idx+1,postEnd-1);
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
        int[] post = new int[n];
        for (int i = 0; i < n; i++)
            post[i] = scn.nextInt();

        int[] pre = new int[n];
        for (int i = 0; i < n; i++)
            pre[i] = scn.nextInt();

        TreeNode root = constructFromPrePost(pre, post);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}