import java.util.*;

public class _42BurningTree {
  public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }
   static int max = 0;
  public static int burningTree(TreeNode root, int fireNode) {
    List<TreeNode> list = nodeToRootPath(root,fireNode);
    TreeNode prev = null;
    for(int i = 0; i < list.size(); i++) {
        helper(list.get(i),prev,i);
        prev = list.get(i);
    }
    return max;
  }
  
  private static void helper(TreeNode node,TreeNode block,int k) {
      if(node == null || node == block) {
          return;
      }
      max = Math.max(max,k);
      helper(node.left,block,k+1);
      helper(node.right,block,k+1);
  }
  
  private static List<TreeNode> nodeToRootPath(TreeNode node,int tar) {
      if(node == null) return new ArrayList<>();
      if(node.val == tar) {
        List<TreeNode> list = new ArrayList<>();
        list.add(node);
        return list;
      }
      
      List<TreeNode> left = nodeToRootPath(node.left,tar);
      if(left.size() > 0) {
          left.add(node);
          return left;
      }
      
      List<TreeNode> right = nodeToRootPath(node.right,tar);
      if(right.size() > 0) {
          right.add(node);
          return right;
      }
      return new ArrayList<>();
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
    int fireNode = scn.nextInt();

    int ans = burningTree(root, fireNode);
    System.out.println(ans);

  }

  public static void main(String[] args) {
    solve();
  }
}