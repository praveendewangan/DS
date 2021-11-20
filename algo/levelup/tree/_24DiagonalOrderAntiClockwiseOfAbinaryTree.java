import java.util.*;

public class _24DiagonalOrderAntiClockwiseOfAbinaryTree {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static ArrayList<ArrayList<Integer>> diagonalOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        } 
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.size() > 0) {
            int size = q.size();
            ArrayList<Integer> list = new ArrayList<>();
            while(size-- > 0) {
                TreeNode rm = q.remove();
                while(rm != null) {
                    list.add(rm.val);
                    if(rm.right != null) {
                        q.add(rm.right);
                    }
                    rm = rm.left;
                }
            }
            res.add(list);
        }
        
        
        return res;
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

        ArrayList<ArrayList<Integer>> ans = diagonalOrder(root);
        int idx = 0;
        for (ArrayList<Integer> i : ans) {
            System.out.print(idx++ + " -> ");
            for (Integer j : i)
                System.out.print(j + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solve();
    }
}