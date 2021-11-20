import java.util.Scanner;

public class _12RecoverBST {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    
    private static TreeNode prev = null;
    private static TreeNode cur = null;
    private static TreeNode p1 = null;
    private static TreeNode p2 = null;
    public static void recoverTree(TreeNode root) {
        if(root == null) return;
        helper(root);
        if(p1 != null && p2 != null) {
            int val = p1.val;
            p1.val = p2.val;
            p2.val = val;
        }
    }
    
    private static void helper(TreeNode node) {
        if(node == null) return;
        
        helper(node.left);
        if(prev == null) {
            prev = node;
        } else {
            cur = node;
            if(prev.val > cur.val) {
                if(p2 == null) {
                    // first encounter
                    p1 = prev;
                    p2 = cur;
                } else {
                    // second encounter
                    p2 = node;
                }
            }
            prev = node;
        }
        helper(node.right);
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
        recoverTree(root);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}