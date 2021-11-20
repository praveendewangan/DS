import java.util.*;

public class _44MaximumWidthOfBinaryTree {
  public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }

  private static class WPair {
        TreeNode node;
        int indx;

        public WPair(TreeNode node, int indx) {
            this.node = node;
            this.indx = indx;
        }
    }

    public static int widthOfBinaryTree(TreeNode root) {
        Queue<WPair> qu = new LinkedList<>();
        qu.add(new WPair(root, 0));
        int maxWidth = 0;
        while(qu.size() > 0) {
            int size = qu.size();
            int lm = qu.peek().indx; // left most index
            int rm = qu.peek().indx; // right most index
            while(size-- > 0) {
                // 1. get + remove
                WPair rem = qu.remove();
                // 2. work  
                rm = rem.indx;
                // 3. add children with index
                if(rem.node.left != null) {
                    qu.add(new WPair(rem.node.left, 2 * rem.indx + 1));
                }
                if(rem.node.right != null) {
                    qu.add(new WPair(rem.node.right, 2 * rem.indx + 2));
                }
            }
            // width of current level
            int width = rm - lm + 1;
            // maximise overall width
            maxWidth = Math.max(maxWidth, width);
        }
        return maxWidth;
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

    int ans = widthOfBinaryTree(root);
    System.out.println(ans);
  }

  public static void main(String[] args) {
    solve();
  }
}