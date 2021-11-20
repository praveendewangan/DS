import java.util.Scanner;

public class _40MaximumPathSumInBetweenTwoLeafs {
  public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }

   static int maxPathSum = Integer.MIN_VALUE;

    private static int maxPathSum1(TreeNode node) {
        int sum = 0;
        if(node.left != null && node.right != null) {
            int lsum = maxPathSum1(node.left);
            int rsum = maxPathSum1(node.right);
            maxPathSum = Math.max(maxPathSum, lsum + rsum + node.val);
            sum = Math.max(lsum, rsum) + node.val;
        } else if(node.left != null) {
            int lsum = maxPathSum1(node.left);
            sum = lsum + node.val;
        } else if(node.right != null) {
            int rsum = maxPathSum1(node.right);
            sum = rsum + node.val;
        } else {
            sum = node.val;            
        }
        return sum;
    }

    static int maxPathSum(TreeNode node) { 
        if(node == null) return 0;
        maxPathSum = Integer.MIN_VALUE;
        if(node.left != null && node.right != null) {
            int lsum = maxPathSum1(node.left);
            int rsum = maxPathSum1(node.right);
            maxPathSum = Math.max(maxPathSum, lsum + rsum + node.val);
        } else if(node.left != null) {
            int lsum = maxPathSum1(node.left);
            maxPathSum = Math.max(maxPathSum, lsum + node.val);
        } else if(node.right != null) {
            int rsum = maxPathSum1(node.right);
            maxPathSum = Math.max(maxPathSum, rsum + node.val);
        } else {
            // maxPathSum = node.data;
        }
        return maxPathSum;
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