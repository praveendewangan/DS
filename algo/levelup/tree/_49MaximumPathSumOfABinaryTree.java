import java.util.Scanner;

public class _49MaximumPathSumOfABinaryTree {
  public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }

      static int maxPath = 0;
    
    private static int maxPathSum_(TreeNode root) {
        if(root == null) return (int)-1e9;

        int lsum = maxPathSum_(root.left);
        int rsum = maxPathSum_(root.right);

        int val = Math.max(root.val, Math.max(lsum + root.val, rsum + root.val));
        maxPath = Math.max(maxPath, Math.max(val, lsum + root.val + rsum));

        return val;
    }

    public static int maxPathSum(TreeNode root) {
        maxPath = Integer.MIN_VALUE;   
        maxPathSum_(root);
        return maxPath;
    }

  // input_Section=================================================

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
    System.out.println(maxPathSum(root));
  }

  public static void main(String[] args) {
    solve();
  }
}