import java.util.*;

public class _26DiagonalOrderSumOfABinaryTree {
  public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }

  public static ArrayList<Integer> diagonalOrderSum(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        } 
        ArrayList<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.size() > 0) {
            int size = q.size();
            int sum = 0;
            while(size-- > 0) {
                TreeNode rm = q.remove();
                while(rm != null) {
                    sum += rm.val;
                    if(rm.left != null) {
                        q.add(rm.left);
                    }
                    rm = rm.right;
                }
            }
            res.add(sum);
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

    ArrayList<Integer> ans = diagonalOrderSum(root);
    for (Integer j : ans)
      System.out.print(j + " ");

  }

  public static void main(String[] args) {
    solve();
  }
}

