import java.util.Scanner;

public class _8CameraInBinaryTree {
    // LC968
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private static int camera = 0;
    public static int MinCamerasInBT(TreeNode root) {
        int state = helper(root);
        if(state == 2) camera++;
        return camera;
    }
    private static int helper(TreeNode node) {
        if(node == null) return 1;
        
        int left = helper(node.left);
        int right = helper(node.right);
        
        if(left == 1 && right == 1) {
            return 2;
        } else if(left == 2 || right == 2) {
            camera++;
            return 0;
        } else {
            return 1;
        }
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
        System.out.println(MinCamerasInBT(root));

    }

    public static void main(String[] args) {
        solve();
    }
}