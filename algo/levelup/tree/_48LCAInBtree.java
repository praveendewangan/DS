import java.util.*;

public class _48LCAInBtree {
  public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }

  static TreeNode lca = null;

    private static boolean solveLCA(TreeNode node, int data1, int data2) {
        if(node == null) return false;
        boolean self = node.val == data1 || node.val == data2;
        boolean left = false, right = false;
        left = solveLCA(node.left, data1, data2);
        if(lca == null)
            right = solveLCA(node.right, data1, data2);
        if((self && left) || (self && right) || (left && right)) {
            lca = node;
        }
        return self || left || right;
    }

    public static TreeNode lowestCommonAncestor(TreeNode node, int p, int q) {
        lca = null;
        solveLCA(node, p, q);
        return lca;
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

  public static int idx = 0;

  private static TreeNode deserialize(String[] arr) {
    if (idx >= arr.length || arr[idx].equals("null")) {
      idx++;
      return null;
    }

    TreeNode node = new TreeNode(Integer.parseInt(arr[idx++]));
    node.left = deserialize(arr);
    node.right = deserialize(arr);

    return node;
  }

  public static TreeNode deserialize(String str) {
    String[] arr = str.split(" ");
    return deserialize(arr);
  }

  public static void solve() {
    String str = scn.nextLine();
    TreeNode root = deserialize(str);

    int e1 = scn.nextInt();
    int e2 = scn.nextInt();

    TreeNode ans = lowestCommonAncestor(root, e1, e2);
    System.out.println(ans == null ? null : ans.val);
  }

  public static void main(String[] args) {
    solve();
  }
}