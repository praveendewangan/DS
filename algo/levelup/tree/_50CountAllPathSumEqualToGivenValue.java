import java.util.*;

public class _50CountAllPathSumEqualToGivenValue {
  public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }

    static int count = 0;
  public static int pathSum(TreeNode root, int K) {
    Map<Integer,Integer> map = new HashMap<>(); 
    count = 0;
    helper(root,K,0,map);
    return count;
  }
  
  private static void helper(TreeNode node,int k,int sum,Map<Integer,Integer> map) {
      if(node == null) return;
      int val = sum + node.val;
      if(val == k) {
          count++;
      }
      count += map.get(val-k) == null ? 0 : map.get(val-k);
      if(map.get(val) == null) {
          map.put(val,0);
      }
      map.put(val,map.get(val)+1);
      helper(node.left,k,val,map);
      helper(node.right,k,val,map);
      
      map.put(val,map.get(val)-1);
      
      
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
    int tar = scn.nextInt();

    int ans = pathSum(root, tar);
    System.out.println(ans);
  }

  public static void main(String[] args) {
    solve();
  }
}