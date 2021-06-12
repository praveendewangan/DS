
import java.io.IOException;
  import java.util.*;
  
  class TreeNode {
  	  TreeNode left, right;
  	  int data;
  
  	  TreeNode(int d) {
  	  	  data = d;
  	  	  left = right = null;
  	  }
  
  }
  
  class BinaryTree {
  
  	  class Pair {
  	      TreeNode node;
  	      int ht;
  	      public Pair(TreeNode node,int ht) {
  	          this.node = node;
  	          this.ht = ht;
  	      }
  	  }
  	  static int dia = 0;
  	  public int diameterOfBinaryTree(TreeNode root) {
          diameter(root);
          return dia;
  	  }
  	  private static int diameter(TreeNode node){
  	      if(node == null) return -1;
      
          int lh = diameter(node.left);
          int rh = diameter(node.right);
          dia = Math.max(dia,lh+rh+2);
          return Math.max(lh,rh) + 1;
    }
  
  
  	  
  	  public String levelOrder(TreeNode root) {
  	  	  if (root == null) {
  	  	  	  return "[]";
  	  	  }
  
  	  	  String output = "";
  	  	  Queue<TreeNode> nodeQueue = new LinkedList<>();
  	  	  nodeQueue.add(root);
  	  	  while (!nodeQueue.isEmpty()) {
  	  	  	  TreeNode node = nodeQueue.remove();
  
  	  	  	  if (node == null) {
  	  	  	  	  output += "null ";
  	  	  	  	  continue;
  	  	  	  }
  
  	  	  	  output += String.valueOf(node.data) + " ";
  	  	  	  nodeQueue.add(node.left);
  	  	  	  nodeQueue.add(node.right);
  	  	  }
  	  	  return output.substring(0, output.length() - 1);
  	  }
  
  	  void printPostorder(TreeNode node) {
  	  	  if (node == null)
  	  	  	  return;
  
  	  	  printPostorder(node.left);
  
  	  	  printPostorder(node.right);
  
  	  	  System.out.print(node.data + " ");
  	  }
  
  	  void printPreorder(TreeNode node) {
  	  	  if (node == null)
  	  	  	  return;
  
  	  	  System.out.print(node.data + " ");
  	  	  printPostorder(node.left);
  
  	  	  printPostorder(node.right);
  
  	  }
  
  	  public void inorder(TreeNode root) {
  	  	  if (root != null) {
  	  	  	  inorder(root.left);
  	  	  	  System.out.print(root.data + " ");
  	  	  	  inorder(root.right);
  	  	  }
  	  }
  
  }
  
  public class _14DiameterOfBinaryTree {
    
  
  	  public static TreeNode constructor_levelOderSerailize(Integer[] arr) {
  	  	  ArrayDeque<TreeNode> que = new ArrayDeque<>();
  	  	  TreeNode root = new TreeNode(arr[0]);
  	  	  que.addLast(root);
  	  	  int i = 1;
  	  	  while (!que.isEmpty() && i < arr.length) {
  	  	  	  TreeNode nn = que.removeFirst();
  
  	  	  	  if (i < arr.length && arr[i] != null) {
  	  	  	  	  TreeNode n = new TreeNode(arr[i]);
  	  	  	  	  nn.left = n;
  	  	  	  	  que.addLast(n);
  	  	  	  }
  	  	  	  i++;
  
  	  	  	  if (i < arr.length && arr[i] != null) {
  	  	  	  	  TreeNode n = new TreeNode(arr[i]);
  	  	  	  	  nn.right = n;
  	  	  	  	  que.addLast(n);
  	  	  	  }
  	  	  	  i++;
  	  	  }
  
  	  	  return root;
  	  }
  
  	  public static Integer[] inputSplitSpace(String str) {
  	  	  String[] sArr = str.split(" ");
  	  	  Integer[] arr = new Integer[sArr.length];
  	  	  for (int i = 0; i < arr.length; i++) {
  	  	  	  arr[i] = sArr[i].equals("null") ? null : Integer.parseInt(sArr[i]);
  	  	  }
  	  	  return arr;
  	  }
  
  	  public static void main(String[] args) throws IOException {
  
  	  	  Scanner s = new Scanner(System.in);
  	  	  String str = s.nextLine();
  	  	  TreeNode root = constructor_levelOderSerailize(inputSplitSpace(str));
  	  	  BinaryTree bt = new BinaryTree();
  	  	  System.out.println(bt.diameterOfBinaryTree(root));
  	  }
  
  }
