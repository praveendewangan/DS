import java.util.*;

public class _31RootToAllLeafPathInBinaryTree {
  public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }

private static void rootToAllLeafPath(TreeNode node, ArrayList<Integer> subres, 
    ArrayList<ArrayList<Integer>> res) {
        if(node == null) return;

        if(node.left == null && node.right == null) {
            // leaf
            ArrayList<Integer> duplicate = new ArrayList<>();
            for(int val : subres) {
                duplicate.add(val);
            }
            duplicate.add(node.val);
            res.add(duplicate);
            return;
        }

        subres.add(node.val);
        rootToAllLeafPath(node.left, subres, res);
        rootToAllLeafPath(node.right, subres, res);
        subres.remove(subres.size() - 1);
    }
    
  public static ArrayList<ArrayList<Integer>> rootToAllLeafPath(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> subres = new ArrayList<>();
        rootToAllLeafPath(root, subres, res);
        return res;
    }
  // input_section=================================================

  public static TreeNode createTree(int[] arr, int[] IDX) {
    if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
      IDX[0]++;
      return null;
    }
    TreeNode Treenode = new TreeNode(arr[IDX[0]++]);
    Treenode.left = createTree(arr, IDX);
    Treenode.right = createTree(arr, IDX);

    return Treenode;
  }

  public static void solve() {
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++)
      arr[i] = scn.nextInt();

    int[] IDX = new int[1];
    TreeNode root = createTree(arr, IDX);

    ArrayList<ArrayList<Integer>> ans = rootToAllLeafPath(root);
    if (ans.size() == 0)
      System.out.println();
    for (ArrayList<Integer> al : ans) {
      for (Integer ele : al)
        System.out.print(ele + " ");
      System.out.println();
    }
  }

  public static void main(String[] args) {
    solve();
  }
}