import java.util.*;

public class _4ConstructBinaryTreeFromInorderAndLevelorder {
  public static Scanner scn = new Scanner(System.in);

  static class TreeNode {
    int val;
    TreeNode left = null, right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }

  public static TreeNode buildTree(int[] inorder, int[] levelOrder) {
      List<Integer> level = new ArrayList<>();
      for(int val : levelOrder){
          level.add(val);
      }
      return helper(inorder,level,0,levelOrder.length-1);
  }
  
  private static TreeNode helper(int[] in,List<Integer> level,int inst,int inend) {
      if(level.size() == 0) return null;
      
      int val = level.get(0);
      TreeNode node = new TreeNode(val);
      int idx = inst;
      Set<Integer> set = new HashSet<>();
      while(in[idx] != val) {
          set.add(in[idx]);
          idx++;
      }
      List<Integer> llvl = new ArrayList<>();
      List<Integer> rlvl = new ArrayList<>();
      
      for(int i = 1; i < level.size(); i++) {
          int data = level.get(i);
          if(set.contains(data)) {
              llvl.add(data);
          } else {
              rlvl.add(data);
          }
      }
      
      node.left = helper(in,llvl,inst,idx-1);
      node.right = helper(in,rlvl,idx+1,inend);
      return node;
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

public static void solve() {
  int n = scn.nextInt();

  int[] InOrder = new int[n];
  for (int i = 0; i < n; i++)
    InOrder[i] = scn.nextInt();

  int[] LevelOrder = new int[n];
  for (int i = 0; i < n; i++)
    LevelOrder[i] = scn.nextInt();

  TreeNode root = buildTree(InOrder, LevelOrder);
  display(root);
}

public static void main(String[] args) {
  solve();
}

}