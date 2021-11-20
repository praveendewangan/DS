import java.util.*;

public class _36MorrisPostOrderTraversal {
  public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }
  
  public static TreeNode getLeftMostNode(TreeNode temp, TreeNode curr) {
    while(temp.left != null && temp.left != curr) {
        temp = temp.left;
    }
    return temp;
}

public static ArrayList<Integer> morrisPostTraversal(TreeNode node) {
    ArrayList<Integer> res = new ArrayList<>();
    TreeNode curr = node;

    while(curr != null) {
        TreeNode rightNode = curr.right;
        if(rightNode != null) {
            TreeNode leftMostNode = getLeftMostNode(rightNode, curr);
            if(leftMostNode.left != curr) {
                res.add(curr.val);
                leftMostNode.left = curr;
                curr = curr.right;
            } else {
                leftMostNode.left = null;
                curr = curr.left;
            }
        } else {
            res.add(curr.val);
            curr = curr.left;
        }
    }
    // reverse of res
    int left = 0;
    int right = res.size() - 1;

    while(left < right) {
        int val1 = res.get(left);
        int val2 = res.get(right);
        res.set(right, val1);
        res.set(left, val2);
    }
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

    ArrayList<Integer> ans = morrisPreTraversal(root);
    for (Integer i : ans)
      System.out.print(i + " ");

  }

  public static void main(String[] args) {
    solve();
  }
}