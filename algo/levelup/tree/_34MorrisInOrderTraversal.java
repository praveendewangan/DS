import java.util.*;

public class _34MorrisInOrderTraversal {
  public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }

    // morris inorder traversal
    public static TreeNode getRightMostNode(TreeNode temp, TreeNode curr) {
        while(temp.right != null && temp.right != curr) {
            temp = temp.right;
        }
        return temp;
    }

    public static ArrayList<Integer> morrisInTraversal(TreeNode node) {
        ArrayList<Integer> ans = new ArrayList<>();
        TreeNode curr = node;
        while(curr != null) {
            TreeNode leftNode = curr.left;
            if(leftNode != null) {
                TreeNode rightMostNode = getRightMostNode(leftNode, curr);
                if(rightMostNode.right != curr) {
                    // create a thread and move toward left tree
                    rightMostNode.right = curr; // thread creation
                    curr = curr.left;
                } else {
                    // if rightmostnode.right == curr that means left subtree is completely processed
                    // 1. print the value
                    ans.add(curr.val);
                    // 2. break thread
                    rightMostNode.right = null;
                    // 3. move toward right
                    curr = curr.right;
                }
            } else {
                // 1. print value
                ans.add(curr.val);
                // 2. move toward right
                curr = curr.right;
            }
        }
        return ans;
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

    ArrayList<Integer> ans = morrisInTraversal(root);
    for (Integer i : ans)
      System.out.print(i + " ");

  }

  public static void main(String[] args) {
    solve();
  }
}