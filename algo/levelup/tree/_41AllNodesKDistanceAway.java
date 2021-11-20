import java.util.*;

public class _41AllNodesKDistanceAway {
  public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }

  public static ArrayList<Integer> distanceK(TreeNode root, int target, int k) {
        List<TreeNode> paths = nodeToRootPath(root,target);
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < paths.size(); i++){
            if(i == 0) {
                getKLevelsDown(paths.get(i),k - i,null,res);
            } else {
                getKLevelsDown(paths.get(i),k - i,paths.get(i-1),res);
            }
        }
        return res;
  }
  
  private static void getKLevelsDown(TreeNode node,int k,TreeNode block,ArrayList<Integer> list) {
      if(node == null || node == block){
          return;
      }
      
      if(k == 0) {
          list.add(node.val);
          return;
      }
      getKLevelsDown(node.left,k-1,block,list);
      getKLevelsDown(node.right,k-1,block,list);
  }
  
  private static List<TreeNode> nodeToRootPath(TreeNode node,int data) {
        if(node == null){
            return new ArrayList<>();
        }
        if(node.val == data){
            List<TreeNode> list = new ArrayList<>();
            list.add(node);
            return list;
        }
        List<TreeNode> list = nodeToRootPath(node.left,data);
        if(list.size() > 0 ) {
            list.add(node);
            return list;
        }
        list = nodeToRootPath(node.right,data);
        if(list.size() > 0 ) {
            list.add(node);
            return list;
        }
        return list;
        
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
    int target = scn.nextInt();
    int k = scn.nextInt();

    ArrayList<Integer> ans = distanceK(root, target, k);
    if (ans.size() == 0)
      System.out.println();
    for (Integer ele : ans)
      System.out.println(ele + " ");

  }

  public static void main(String[] args) {
    solve();
  }
}