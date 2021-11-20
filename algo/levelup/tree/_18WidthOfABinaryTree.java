import java.util.*;

public class _18WidthOfABinaryTree {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private static int lval = 0; 
    private static int rval = 0; 
    public static int width(TreeNode root) {
        lval = 0;
        rval = 0;
        dfs(root,0);
       return rval-lval+1;
    }
    
    private static void dfs(TreeNode node,int val) {
        if(node == null) return;
        
        lval = Math.min(lval,val);
        rval = Math.max(rval,val);

        dfs(node.left,val-1);
        dfs(node.right,val+1);
    }

    // input_section=================================================

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
            IDX[0]++;
            return null;
        }
        TreeNode node = new TreeNode(arr[IDX[0]++]);
        node.left = createTree(arr, IDX);
        node.right = createTree(arr, IDX);

        return node;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);

        System.out.println(width(root));
    }

    public static void main(String[] args) {
        solve();
    }
}