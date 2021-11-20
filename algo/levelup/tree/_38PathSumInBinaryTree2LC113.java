import java.util.*;

public class _38PathSumInBinaryTree2LC113 {
  public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }

  public static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int targetSum) {
      ArrayList<ArrayList<Integer>> res = new ArrayList<>();
      helper(root,0,targetSum,new ArrayList<>(),res);
    return res;
  }
  
  private static void helper(TreeNode node,int sum,int tar,ArrayList<Integer> list,ArrayList<ArrayList<Integer>> res) {
      if(node == null) return;
      if(node.left == null && node.right == null && sum+node.val == tar) {
          list.add(node.val);
          res.add(new ArrayList<>(list));
          list.remove(list.size()-1);
          return;
      }
      list.add(node.val);
      helper(node.left,sum+node.val,tar,list,res);
      helper(node.right,sum+node.val,tar,list,res);
      list.remove(list.size()-1);
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
    int tar = scn.nextInt();
    int[] IDX = new int[1];
    TreeNode root = createTree(arr, IDX);
    ArrayList<ArrayList<Integer>> ans = pathSum(root, tar);
    if (ans.size() == 0) System.out.println(" ");
    for (ArrayList<Integer> ar : ans) {
      for (Integer ele : ar) {
        System.out.print(ele + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    solve();
  }
}