import java.util.*;

public class _43BurningTree2 {
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
  public static ArrayList<ArrayList<Integer>> burningTree(TreeNode root, int fireNode) {
    List<TreeNode> list = nodeToRootPath(root,fireNode);
    TreeNode prev = null;
    // Map<Integer,ArrayList<Integer>> map = new HashMap<>();
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    for(int i = 0; i < list.size(); i++) {
        helper(list.get(i),prev,i,res);
        prev = list.get(i);
    }
    // for(int key : map.keySet()){
    //     res.add(new ArrayList<>());
    // }
    // for(int key : map.keySet()){
    //     res.set(key,map.get(key));
    // }
    return res;
  }
  
  private static void helper(TreeNode node,TreeNode block,int k,ArrayList<ArrayList<Integer>> res) {
      if(node == null || node == block) {
          return;
      }
      if(res.size() == k) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(node.val);
        res.add(list);
      } else {
          res.get(k).add(node.val);
      }
      helper(node.left,block,k+1,res);
      helper(node.right,block,k+1,res);
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

    ArrayList<ArrayList<Integer>> ans = burningTree(root, fireNode);
    if (ans.size() == 0)
      System.out.println();
    for (ArrayList<Integer> ar : ans) {
      for (Integer ele : ar)
        System.out.print(ele + " ");
      System.out.println();
    }
  }

  public static void main(String[] args) {
    solve();
  }
}