import java.util.Scanner;

public class _10LargestZigZagPathInBinaryTree {
    // LC1372
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static class Pair {
        int lStart;
        int rStart;
        int omax;
        public Pair(int lStart,int rStart,int omax) {
            this.lStart = lStart;
            this.rStart = rStart;
            this.omax = omax;
        }
    }
    public static int longestZigZagPath(TreeNode root) {
        return helper(root).omax;
    }
    
    private static Pair helper(TreeNode node) {
        if(node == null) return new Pair(-1,-1,0);
        
        Pair left = helper(node.left);
        Pair right = helper(node.right);
        
        int leftStart = left.rStart + 1;
        int rightStart = right.lStart + 1;
        int omax = Math.max(Math.max(left.omax,right.omax),Math.max(leftStart,rightStart));
        
        
        return new Pair(leftStart,rightStart,omax);
    }

    // input_Section_====================================================================

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1){
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

        System.out.println(longestZigZagPath(root));
    }

    public static void main(String[] args) {
        solve();
    }
}